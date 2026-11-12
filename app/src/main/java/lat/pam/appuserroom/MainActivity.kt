
package lat.pam.appuserroom

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {

    private val viewModel: UserViewModel by viewModels()
    private var editUser: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val rvUsers = findViewById<RecyclerView>(R.id.rvUser)

        // Adapter
        val adapter = UserAdapter(
            emptyList(),

            onEdit = { user ->
                editUser = user

                etName.setText(user.name)
                etEmail.setText(user.email)

                btnAdd.text = "Update User"
            },

            onDelete = { user ->
                viewModel.delete(user)

                if (editUser?.id == user.id) {
                    editUser = null
                    etName.text.clear()
                    etEmail.text.clear()
                    btnAdd.text = "Add User"
                }

                Toast.makeText(
                    this,
                    "User berhasil dihapus",
                    Toast.LENGTH_SHORT
                ).show()
            }
        )

        // RecyclerView
        rvUsers.layoutManager = LinearLayoutManager(this)
        rvUsers.adapter = adapter

        // Mengamati data Room
        viewModel.allUsers.observe(this) { users ->
            adapter.setData(users)
        }

        // Tombol Add dan Update
        btnAdd.setOnClickListener {

            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(
                    this,
                    "Nama dan email harus diisi!",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            if (editUser == null) {

                viewModel.insert(
                    User(
                        name = name,
                        email = email
                    )
                )

                Toast.makeText(
                    this,
                    "User berhasil ditambahkan",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                viewModel.update(
                    editUser!!.copy(
                        name = name,
                        email = email
                    )
                )

                editUser = null
                btnAdd.text = "Add User"

                Toast.makeText(
                    this,
                    "User berhasil diperbarui",
                    Toast.LENGTH_SHORT
                ).show()
            }

            // Kosongkan form
            etName.text.clear()
            etEmail.text.clear()
        }
    }
}
