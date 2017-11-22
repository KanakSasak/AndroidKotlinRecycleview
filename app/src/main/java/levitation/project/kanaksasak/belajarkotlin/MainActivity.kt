
/*
 * Copyright (c) 2017. By Lalu Raynaldi Pratama Putra
 */

package levitation.project.kanaksasak.belajarkotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btn)
        btn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ListViewKot::class.java)
            startActivity(intent)

        })

    }

}
