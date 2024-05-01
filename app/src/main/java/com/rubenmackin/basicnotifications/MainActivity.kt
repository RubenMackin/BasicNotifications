package com.rubenmackin.basicnotifications

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rubenmackin.basicnotifications.data.TopicsService.Companion.BASKETBALL_TOPIC
import com.rubenmackin.basicnotifications.data.TopicsService.Companion.FOOTBALL_TOPIC
import com.rubenmackin.basicnotifications.data.TopicsService.Companion.PETANCA_TOPIC
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val mainViewModel by viewModels<MainViewModel>()
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

        initUI()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initUI() {
        initListeners()
    }

    private fun initListeners() {
        findViewById<Button>(R.id.btnFootball).setOnClickListener{
            mainViewModel.subscribeToTopic(FOOTBALL_TOPIC)
        }

        findViewById<Button>(R.id.btnBasketBall).setOnClickListener{
            mainViewModel.subscribeToTopic(BASKETBALL_TOPIC)
        }

        findViewById<Button>(R.id.btnPetanca).setOnClickListener{
            mainViewModel.subscribeToTopic(PETANCA_TOPIC)
        }
    }
}