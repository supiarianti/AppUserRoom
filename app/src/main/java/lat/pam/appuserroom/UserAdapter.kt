
package lat.pam.appuserroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    private var users: List<User>,
    private val onEdit: (User) -> Unit,
    private val onDelete: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        val tvName: TextView =
            view.findViewById(R.id.tvName)

        val tvEmail: TextView =
            view.findViewById(R.id.tvEmail)

        val btnEdit: Button =
            view.findViewById(R.id.btnEdit)

        val btnDelete: Button =
            view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val user = users[position]

        holder.tvName.text = user.name
        holder.tvEmail.text = user.email

        holder.btnEdit.setOnClickListener {
            onEdit(user)
        }

        holder.btnDelete.setOnClickListener {
            onDelete(user)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setData(newUsers: List<User>) {
        users = newUsers
        notifyDataSetChanged()
    }
}
