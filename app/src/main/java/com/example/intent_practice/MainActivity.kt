package com.example.intent_practice

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_FOR_NICKNAME = 1005

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        smsBtn.setOnClickListener {

            val inputPhoneNum = phoneNumEdt.text.toString()

            val myuri = Uri.parse("smsto:${inputPhoneNum}")

            val myIntent = Intent(Intent.ACTION_SENDTO, myuri)

            myIntent.putExtra("sms_body", "미리 내용 입력")

            startActivity(myIntent)

        }

        callBtn.setOnClickListener {

            val inputPhoneNum = phoneNumEdt.text.toString()

            val myuri = Uri.parse("tel:${inputPhoneNum}")

            val myIntent = Intent(Intent.ACTION_CALL, myuri)

            startActivity(myIntent)

        }

//        DIAL 액션 예제

        dialBtn.setOnClickListener {

//            phoneNumEdt에 입력한 전화번호를 받아서 => 해당 번호에 전화 연결

            val inputPhoneNum = phoneNumEdt.text.toString()

            val myuri = Uri.parse("tel:${inputPhoneNum}")

            val myIntent = Intent(Intent.ACTION_DIAL, myuri)

            startActivity(myIntent)
        }

      editNicknameBtn.setOnClickListener {

            val myIntent = Intent(this,EditNickMainActivity::class.java)
            startActivityForResult(myIntent,REQUEST_FOR_NICKNAME )

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        돌아온 이유가 닉네임을 받으로 다녀온게 맞는지?
        if (requestCode == REQUEST_FOR_NICKNAME) {

//        추가질문 : 확인을 눌러서 돌아온게 맞는가?
            if(resultCode == RESULT_OK) {

//                실제 첨부된 새 닉네임을 꺼내서 텍스트뷰에 반영
                val newNickname = data?.getStringExtra("nickname")
                nicknameTxt.text = newNickname


            }
        }
    }


}