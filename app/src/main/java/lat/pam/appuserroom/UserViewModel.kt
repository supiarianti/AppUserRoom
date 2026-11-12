
package lat.pam.appuserroom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(application: Application) :
    AndroidViewModel(application) {

    private val dao =
        AppDatabase.getDatabase(application).userDao()

    val allUsers: LiveData<List<User>> =
        dao.getAllUsers()

    fun insert(user: User) {
        viewModelScope.launch {
            dao.insert(user)
        }
    }

    fun update(user: User) {
        viewModelScope.launch {
            dao.update(user)
        }
    }

    fun delete(user: User) {
        viewModelScope.launch {
            dao.delete(user)
        }
    }
}
