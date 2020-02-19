package com.example.rvapp


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rvapp.data.User
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), UserAdapter.onListInteraction {


    val users = mutableListOf<User>()
    val usersObjList = mutableListOf<User>()
    private var adapter : UserAdapter? = null
    var count: Int = 0
    lateinit var navController: NavController
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)


        usersObjList.add(User("Mr1","Jhon1","Wick1","jwick1@gmail.com","66600066611"))
        usersObjList.add(User("Mr2","Jhon2","Wick2","jwick2@gmail.com","66600066612"))
        usersObjList.add(User("Mr3","Jhon3","Wick3","jwick3@gmail.com","66600066613"))
        usersObjList.add(User("Mr4","Jhon4","Wick4","jwick4@gmail.com","66600066614"))
        usersObjList.add(User("Mr5","Jhon5","Wick5","jwick5@gmail.com","66600066615"))
        usersObjList.add(User("Mr6","Jhon6","Wick6","jwick6@gmail.com","66600066616"))
        usersObjList.add(User("Mr7","Jhon7","Wick7","jwick7@gmail.com","66600066617"))
        usersObjList.add(User("Mr8","Jhon8","Wick8","jwick8@gmail.com","66600066618"))


        adapter = UserAdapter(users, this)

        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter

        view.floatingActionButton.setOnClickListener{
            if (count < usersObjList.size) {
                users.add(usersObjList[count])
                count++
                adapter!!.updateData()
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }
    override fun onListItemInteraction(item: User?) {
        this.navController.navigate(R.id.action_mainFragment_to_personalFragment)
        Log.d("KRecyclerView","OnListItemInteraction "+item!!.name)
    }

    override fun onListButtonInteraction(item: User?) {
        users.remove(item)
        adapter!!.updateData()
    }

}
