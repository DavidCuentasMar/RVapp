package com.example.rvapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.rvapp.data.User
import kotlinx.android.synthetic.main.fragment_personal.*
import kotlinx.android.synthetic.main.fragment_personal.view.*

/**
 * A simple [Fragment] subclass.
 */
class PersonalFragment : Fragment() {

    lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_personal, container, false)





        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        user = arguments!!.getParcelable("data")!!

        view.text_name.text =user.name
        view.text_lastname.text = user.lastname

        Glide.with(this).load(user.photo).into(view.imageView)
    }


}
