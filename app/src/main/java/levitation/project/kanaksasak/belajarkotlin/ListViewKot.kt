/*
 * Copyright (c) 2017. By Lalu Raynaldi Pratama Putra
 */

package levitation.project.kanaksasak.belajarkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import java.util.ArrayList

class ListViewKot : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_kot)

        val list: RecyclerView = findViewById(R.id.list)
        list.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val dat = ArrayList<data>()
        dat.add(data("Indonesia"))
        dat.add(data("Malaysia"))
        dat.add(data("USA"))
        dat.add(data("Thailand"))
        dat.add(data("Lombok"))

        val adapt = ListAdapter(dat,this)

        list.adapter = adapt
    }


}


