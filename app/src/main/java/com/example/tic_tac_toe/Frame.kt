package com.example.tic_tac_toe

import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_frame.*
import kotlinx.android.synthetic.main.activity_winner_box.*


class Frame : AppCompatActivity() {
    lateinit var xwins : TextView
    lateinit var owins  : TextView
    lateinit var button1 : ImageView
    lateinit var button2 : ImageView
    lateinit var button3 : ImageView
    lateinit var button4 : ImageView
    lateinit var button5 : ImageView
    lateinit var button6 : ImageView
    lateinit var button7 : ImageView
    lateinit var button8 : ImageView
    lateinit var button9 : ImageView
    lateinit var dialogbox : Dialog
    var turn : Int= 0

    var xw : Int= 0
    var ow : Int = 0
    var winner = "none"
    var gameState = intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2,2)
    var last = "O"

    fun clicked(box: ImageView,number:Int){
        turn += 1
        Log.d("truen", turn.toString())
        val run = winX()

        if (run =="none" && turn != 9){
            if (last == "O"){


                val tagged= box.tag
                if (tagged == "null"){
                    box.setImageResource(R.drawable.ximage)
                    last =  "X"
                    gameState[number] = 1
                }
                box.tag = last


            } else {


                val tagged = box.tag
                if (tagged == "null"){
                    box.setImageResource(R.drawable.oimage)
                    last =  "O"
                    gameState[number] = 0

                }
                box.tag = last


            }


        }

        else {

            resetboard()
        }
        winX()
    }
    var winPositions = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(3, 6, 9),
        intArrayOf(1, 5, 9),
        intArrayOf(3, 5, 7)
    )
    fun winX():String{

        for (i in 0..7){
            val a =gameState[winPositions[i][0]]
            val b =gameState[winPositions[i][1]]
            val c =gameState[winPositions[i][2]]


            if (a==b && a == c && a!= 2){
                winner = if (a == 1) {
                    "X"


                }else {
                    "O"


                }
                if (a==1){
                    xw += 1
                    dialogbox.setContentView(R.layout.activity_winner_box)
                    dialogbox.setCancelable(true)
                    updatedialog("X")
                    dialogbox.show()
                }else if (a == 0){
                    ow += 1
                    dialogbox.setContentView(R.layout.activity_winner_box)
                    dialogbox.setCancelable(true)
                    updatedialog("O")
                    dialogbox.show()
                }
                xwins.text = xw.toString()
                owins.text = ow.toString()
                resetboard()
                break
            }else if (turn == 9){
                winner = "XO"
                dialogbox.setContentView(R.layout.activity_winner_box)
                dialogbox.setCancelable(true)
                updatedialog("XO")
                dialogbox.show()

                break
            }

        }


        return winner
    }
    fun updatedialog(winner : String){
        val winnerimage = dialogbox.findViewById(R.id.winnerimage) as ImageView
        val winnername = dialogbox.findViewById(R.id.winnerbox) as TextView

        if (winner == "X"){
            winnerimage.setImageResource(R.drawable.ximage)
            winnername.text = "X Wins"
        }else if(winner == "O"){
            winnerimage.setImageResource(R.drawable.oimage)
            winnername.text = "O Wins"
        }else {
            winnerimage.setImageResource(R.drawable.parallel)
        }
    }
    fun resetboard(){
        Thread.sleep(1_000)
        this.last=  "O"
        this.winner = "none"
        this.gameState = intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2,2)
        turn = 0

        button1.setImageDrawable(null)
        button2.setImageDrawable(null)
        button3.setImageDrawable(null)
        button4.setImageDrawable(null)
        button5.setImageDrawable(null)
        button6.setImageDrawable(null)
        button7.setImageDrawable(null)
        button8.setImageDrawable(null)
        button9.setImageDrawable(null)


        button1.tag = "null"
        button2.tag = "null"
        button3.tag = "null"
        button4.tag = "null"
        button5.tag = "null"
        button6.tag = "null"
        button7.tag = "null"
        button8.tag = "null"
        button9.tag = "null"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame)
        button1 = findViewById(R.id.box1)
        button2 = findViewById(R.id.box2)
        button3 = findViewById(R.id.box3)
        button4 = findViewById(R.id.box4)
        button5 = findViewById(R.id.box5)
        button6 = findViewById(R.id.box6)
        button7 = findViewById(R.id.box7)
        button8 = findViewById(R.id.box8)
        button9 = findViewById(R.id.box9)
        xwins = findViewById(R.id.p1score)
        owins = findViewById(R.id.p2score)
        dialogbox = Dialog(this)














        button1.setOnClickListener {
            clicked(button1,1)
        }
        button2.setOnClickListener {
            clicked(button2,2)
        }
        button3.setOnClickListener {
            clicked(button3,3)
        }
        button4.setOnClickListener {
            clicked(button4,4)
        }
        button5.setOnClickListener {
            clicked(button5,5)
        }
        button6.setOnClickListener {
            clicked(button6,6)
        }
        button7.setOnClickListener {
            clicked(button7,7)
        }
        button9.setOnClickListener {
            clicked(button9,9)
        }
        button8.setOnClickListener {
            clicked(button8,8)
        }



    }
}
