package com.example.intent_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_FOR_NICKNAME = 1005

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNicknameBtn.setOnClickListener {

            val myIntent = Intent(this,EditNickMainActivity::class.java)
            startActivityForResult(myIntent,1005 )

        }

        sendMessageBtn.setOnClickListener {


            val inputMessage = messageEdt.text.toString()

//            사용자가 입력할 텍스트

            val myIntent = Intent(this, MessageActivity2::class.java)

//            좌표 설정

            myIntent.putExtra("message", inputMessage)

//           사용자의 짐

            startActivity(myIntent)

//            좌표로 이동 시키기

        }

        moveToOtherBtn.setOnClickListener {

//                 다른 화면으로 이동 (OtherActivity)

            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent)





        }

    }
}