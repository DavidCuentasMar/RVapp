package com.example.rvapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rvapp.data.User
import com.example.rvapp.databinding.RowBinding

class UserAdapter(private val nValues: List<User>, private val mListener: onListInteraction) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): ViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        //return ViewHolder(view)
        var binder: RowBinding
        binder = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.row, parent, false)
        return ViewHolder(binder)
    }

    override fun getItemCount(): Int = nValues.size

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val item = nValues[position]
        holder.mView.user = item
        holder.mView.executePendingBindings()
        holder.mView.theLayout.setOnClickListener{
            mListener?.onListItemInteraction(item)
        }
        holder.mView.buttonDeleteUser.setOnClickListener{
            mListener?.onListButtonInteraction(item)
        }

        //holder.mView.setOnClickListener{
            //mListener?.onListItemInteraction(item)
        //}

        //holder.button.setOnClickListener{
            //mListener?.onListButtonInteraction(item)
        //}
    }

    public fun updateData(){
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mView: RowBinding) : RecyclerView.ViewHolder(mView.root){
    }

    interface onListInteraction{
        fun onListItemInteraction(item : User?)
        fun onListButtonInteraction(item : User?)
    }


}