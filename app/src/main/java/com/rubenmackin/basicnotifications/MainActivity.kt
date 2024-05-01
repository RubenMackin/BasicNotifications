package com.rubenmackin.basicnotifications

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //RECUPERAR VALORES QUE NOS MANDA LA NOTIFICACION
        val extras = intent.extras
        if (extras != null){
            val name1 = extras.getString("example1")
            val name2 = extras.getString("example2")
            val name3 = extras.getString("example3")
            Log.i("ruben","el valor de example1 $name1")
            Log.i("ruben","el valor de example2 $name2")
            Log.i("ruben","el valor de example3 $name3")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}