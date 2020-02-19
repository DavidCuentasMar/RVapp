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
    private var adapter: UserAdapter? = null
    var count: Int = 0
    lateinit var navController: NavController
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
      
        val data = arrayOf(
            arrayOf(
                "Mr",
                "Kai",
                "Nordrum",
                "kai.nordrum@example.com",
                "41889319",
                "https://randomuser.me/api/portraits/men/1.jpg"
            ),
            arrayOf(
                "Ms",
                "Holly",
                "May",
                "holly.may@example.com",
                "081-941-0623",
                "https://randomuser.me/api/portraits/women/83.jpg"
            ),
            arrayOf(
                "Miss",
                "Ingebjørg",
                "Kyvik",
                "ingebjorg.kyvik@example.com",
                "45939747",
                "https://randomuser.me/api/portraits/women/24.jpg"
            ),
            arrayOf(
                "Mademoiselle",
                "Anja",
                "Blanchard",
                "anja.blanchard@example.com",
                "077 485 31 66",
                "https://randomuser.me/api/portraits/women/66.jpg"
            ),
            arrayOf(
                "Mr",
                "Thomas",
                "Harris",
                "thomas.harris@example.com",
                "753-780-3557",
                "https://randomuser.me/api/portraits/men/62.jpg"
            ),
            arrayOf(
                "Mr",
                "Olivier",
                "Lévesque",
                "olivier.levesque@example.com",
                "543-120-3225",
                "https://randomuser.me/api/portraits/men/83.jpg"
            ),
            arrayOf(
                "Mr",
                "Guy",
                "Campbell",
                "guy.campbell@example.com",
                "0786-120-185",
                "https://randomuser.me/api/portraits/men/17.jpg"
            ),
            arrayOf(
                "Mr",
                "Ali",
                "Sandalcı",
                "ali.sandalci@example.com",
                "(860)-820-7397",
                "https://randomuser.me/api/portraits/men/52.jpg"
            ),
            arrayOf(
                "Mr",
                "میلاد",
                "نجاتی",
                "myld.njty@example.com",
                "0993-290-6973",
                "https://randomuser.me/api/portraits/men/2.jpg"
            ),
            arrayOf(
                "Ms",
                "Maria",
                "Mortensen",
                "maria.mortensen@example.com",
                "08424600",
                "https://randomuser.me/api/portraits/women/96.jpg"
            ),
            arrayOf(
                "Miss",
                "Johanne",
                "Larsen",
                "johanne.larsen@example.com",
                "78234964",
                "https://randomuser.me/api/portraits/women/84.jpg"
            ),
            arrayOf(
                "Miss",
                "Laura",
                "Perry",
                "laura.perry@example.com",
                "081-042-5718",
                "https://randomuser.me/api/portraits/women/14.jpg"
            ),
            arrayOf(
                "Mr",
                "Luca",
                "Nordstrøm",
                "luca.nordstrom@example.com",
                "49091249",
                "https://randomuser.me/api/portraits/men/42.jpg"
            ),
            arrayOf(
                "Mr",
                "Felix",
                "Li",
                "felix.li@example.com",
                "(717)-775-7178",
                "https://randomuser.me/api/portraits/men/4.jpg"
            ),
            arrayOf(
                "Mr",
                "Ross",
                "Miller",
                "ross.miller@example.com",
                "(277)-361-5983",
                "https://randomuser.me/api/portraits/men/38.jpg"
            ),
            arrayOf(
                "Mr",
                "آرتين",
                "سالاری",
                "artyn.slry@example.com",
                "0984-956-4969",
                "https://randomuser.me/api/portraits/men/78.jpg"
            ),
            arrayOf(
                "Mrs",
                "Ulla",
                "Storm",
                "ulla.storm@example.com",
                "0178-4741101",
                "https://randomuser.me/api/portraits/women/34.jpg"
            ),
            arrayOf(
                "Mr",
                "Louis",
                "Harris",
                "louis.harris@example.com",
                "953-636-9896",
                "https://randomuser.me/api/portraits/men/70.jpg"
            ),
            arrayOf(
                "Miss",
                "Hélèna",
                "Gaillard",
                "helena.gaillard@example.com",
                "06-70-91-26-96",
                "https://randomuser.me/api/portraits/women/59.jpg"
            ),
            arrayOf(
                "Mr",
                "Mille",
                "Larsen",
                "mille.larsen@example.com",
                "91358662",
                "https://randomuser.me/api/portraits/men/5.jpg"
            )
        )

        data.forEach {
            usersObjList.add(
                User(it[0], it[1], it[2], it[3], it[4], it[5])
            )
        }

        adapter = UserAdapter(users, this)

        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter

        view.floatingActionButton.setOnClickListener {
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
