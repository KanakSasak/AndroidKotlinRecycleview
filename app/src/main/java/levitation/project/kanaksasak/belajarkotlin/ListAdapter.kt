/*
 * Copyright (c) 2017. By Lalu Raynaldi Pratama Putra
 */

package levitation.project.kanaksasak.belajarkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.ArrayList
import java.util.zip.Inflater

/**
 * Created by IT on 11/19/2017.
 */
class ListAdapter(items: ArrayList<data>, contex: Context) : RecyclerView.Adapter<ListAdapter.viewHolder>() {

    var mitem = items
    var mContex = contex

    override fun getItemCount(): Int {
        return mitem.size
    }

    override fun onBindViewHolder(holder: viewHolder?, position: Int) {
       var itemname:data = mitem[position]
        holder?.data?.text = itemname.item
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): viewHolder {

        var view:View=LayoutInflater.from(mContex).inflate(R.layout.viewitem,parent,false)

        return viewHolder(view)
    }

    class viewHolder(view: View?) : RecyclerView.ViewHolder(view) {
            var data:TextView? = view?.findViewById(R.id.dataitem)
    }
}