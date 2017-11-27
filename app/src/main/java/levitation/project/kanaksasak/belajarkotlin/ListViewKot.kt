/*
 * Copyright (c) 2017. By Lalu Raynaldi Pratama Putra
 */

package levitation.project.kanaksasak.belajarkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList

class ListViewKot : AppCompatActivity() {

    internal var mFirbaseeDatabase: FirebaseDatabase? = null
    internal var mDatabaseRefrence: DatabaseReference? = null
    lateinit var dat: ArrayList<data>
    lateinit var btn1: Button
    lateinit var txt: EditText
    lateinit var adapt:ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_kot)

        mFirbaseeDatabase = FirebaseDatabase.getInstance()
        mDatabaseRefrence = mFirbaseeDatabase?.getReference("data")

        btn1 = findViewById(R.id.btn1)
        txt = findViewById(R.id.text)
        val list: RecyclerView = findViewById(R.id.list)
        dat = ArrayList<data>()

        list.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        LoadData()

        adapt = ListAdapter(dat, this)


        list.adapter = adapt


    }

    override fun onStart() {
        super.onStart()

        btn1.setOnClickListener(View.OnClickListener {
            val childUpdates = HashMap<String, Any>()
            childUpdates.put("1", txt.text.toString())
            val ownerMap = mapOf(Pair("name", txt.text.toString()))

            mDatabaseRefrence?.push()?.setValue(data(txt.text.toString()))
            //mDatabaseRefrence?.updateChildren(childUpdates)

            Toast.makeText(this, "Push -> " + txt.text, Toast.LENGTH_SHORT).show()
        })
    }

    fun LoadData() {
        mDatabaseRefrence?.orderByKey()?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                fetchData(dataSnapshot)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                println("Error -> " + databaseError)
            }
        })
    }

    fun fetchData(dataSnapshot: DataSnapshot) {
        println("data -> " + dataSnapshot)
        for (child in dataSnapshot.children) {
            val itemval = child.child("item").value
            dat.add(data(itemval.toString()))

            Toast.makeText(this, "Push -> " + itemval.toString(), Toast.LENGTH_SHORT).show()
        }
        adapt.notifyDataSetChanged()
    }


}



