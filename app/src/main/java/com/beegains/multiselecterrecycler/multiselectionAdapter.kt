package com.beegains.multiselecterrecycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import java.lang.IndexOutOfBoundsException

class multiselectionAdapter (var list: ArrayList<model>): RecyclerView.Adapter<multiselectionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): multiselectionAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyler_row, parent, false)

        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: multiselectionAdapter.ViewHolder, position: Int) {
        //holder.bindItems(userList[position],position)
        holder.name.text = list[position].name
        holder.checkbox.isChecked = list[position].isSelected
        holder.checkbox.setTag(position)
        holder.checkbox.setOnCheckedChangeListener{buttonView, isChecked ->
            var cb : CheckBox = buttonView as CheckBox
            var clickedPositon = cb.getTag()
            try {
                list[position].isSelected = cb.isChecked
            }catch (e : IndexOutOfBoundsException){}
        }

    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return list.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name  = itemView.findViewById<TextView>(R.id.name)
        val checkbox = itemView.findViewById<CheckBox>(R.id.checkbox)

    }

    fun getSelectedItem() : ArrayList<model>
    {
        var sortedList : ArrayList<model> = ArrayList()
        for (i in 0 until  list.size)
        {
            var model : model = list.get(i)
            if (model.isSelected)
            {
              sortedList.add(model)
            }
        }
        return  sortedList
    }
    fun  removeItem()
    {
        var list2 = getSelectedItem()
        for (i in 0 until list2.size)
        {
            var model : model = list2.get(i)
            list.remove(model)

        }
        notifyDataSetChanged()
    }
}