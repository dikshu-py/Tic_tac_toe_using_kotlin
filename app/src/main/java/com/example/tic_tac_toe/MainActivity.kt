package com.example.tic_tac_toe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import android.Manifest
import android.app.PendingIntent.getActivity

import android.content.pm.PackageManager

import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager

import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    lateinit var playbutton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playbutton = findViewById(R.id.play_button)
        playbutton.setOnClickListener {
            val intent = Intent(this,Frame::class.java)
            startActivity(intent)
        }
    }
}
