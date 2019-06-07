package com.beegains.multiselecterrecycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
        /**  visit this link : http://www.sunilandroid.com/2016/12/single-and-multiple-item-selection-in.html **/
class MainActivity : AppCompatActivity() {
    var adapter : multiselectionAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?

        btn.setOnClickListener {
         /*   var list =adapter!!.getSelectedItem()
            if (list.size > 0)
            {
                val sb = StringBuilder()
                for ( i in 0 until  list.size)
                {
                    sb.append(list[i].name)
                }
                Toast.makeText(this,sb,Toast.LENGTH_SHORT).show()
            }*/
            adapter!!.removeItem()
        }
        btnset.setOnClickListener { Setvalues() }
    }

    fun Setvalues()
    {
        var list : ArrayList<model> = ArrayList<model>()
        for (i in 0 until  10)
        {
            var model : model = model()
            model.id = i
            model.name = i.toString()
            list.add(model)
        }
       adapter = multiselectionAdapter(list)
        recycler.adapter = adapter

    }

}
