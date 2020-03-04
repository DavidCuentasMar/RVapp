package com.example.rvapp


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rvapp.data.RandomUser
import com.example.rvapp.data.User
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), UserAdapter.onListInteraction {


    val users = mutableListOf<User>()
    private var adapter: UserAdapter? = null

    // UserViewModel
    private lateinit var viewModel: RandomUserViewModel
    // Random User List
    private var randomUserList = mutableListOf<RandomUser>()
    // Nav Controller
    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        viewModel = ViewModelProvider(this).get(RandomUserViewModel::class.java)
        viewModel.addUsers()

        adapter = UserAdapter(users, this)

        getData()

        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter

        return view
    }

    private fun getData() {
        viewModel.getUsers().observe(
            viewLifecycleOwner, Observer { obsU ->
                run {
                    randomUserList = obsU as MutableList<RandomUser>

                    for (randUser in randomUserList) {
                        var temp = User(
                            randUser.name.title,
                            randUser.name.first,
                            randUser.name.last,
                            randUser.email,
                            randUser.phone,
                            randUser.picture.large
                        )

                        users.add(temp)
                    }

                    adapter!!.updateData()
                }
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
    }

    override fun onListItemInteraction(item: User?) {

        var bundle = bundleOf("data" to item)

        this.navController.navigate(R.id.action_mainFragment_to_personalFragment, bundle)
        Log.d("KRecyclerView", "OnListItemInteraction " + item!!.name)
    }

    override fun onListButtonInteraction(item: User?) {
        users.remove(item)
        adapter!!.updateData()
    }

}
