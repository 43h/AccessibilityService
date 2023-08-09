package com.example.demo1

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

object GlobalVariables {
    var FromX: Float = 0f
    var FromY: Float = 1800f
    var ToX: Float = 400f
    var ToY: Float = 1800f
    var Stime: Long = 500
    var Duratin: Long = 100
    var num: Int = 10
    var flag: Int = 1

    var PointX: Float = 460f
    var PointY: Float = 1300f


    var timeout: Long = 1000
}

class MainActivity : ComponentActivity() {
    lateinit var button: Button
    lateinit var button1: Button

    lateinit var editText1: EditText //FromX
    lateinit var editText2: EditText //FromY
    lateinit var editText3: EditText //ToX
    lateinit var editText4: EditText //ToY
    lateinit var editText5: EditText //Stime
    lateinit var editText6: EditText //Duration
    lateinit var editText7: EditText //num
    lateinit var editText8: EditText //stat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContent {
        //    Demo1Theme {
        //       // A surface container using the 'background' color from the theme
        //       Surface(
        //           modifier = Modifier.fillMaxSize(),
        //           color = MaterialTheme.colorScheme.background
        //       ) {
        //           Greeting("Android")
        //       }
        //    }
        //}
        //}
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        button1 = findViewById(R.id.button1)

        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        editText3 = findViewById(R.id.editText3)
        editText4 = findViewById(R.id.editText4)
        editText5 = findViewById(R.id.editText5)
        editText6 = findViewById(R.id.editText6)
        editText7 = findViewById(R.id.editText7)
        editText8 = findViewById(R.id.editText8)

        if (GlobalVariables.flag > 0) {
            button1.text = "start"
        } else {
            button1.text = "stop"
        }

        editText1.setText(GlobalVariables.FromX.toString())
        editText2.setText(GlobalVariables.FromY.toString())
        editText3.setText(GlobalVariables.ToX.toString())
        editText4.setText(GlobalVariables.ToY.toString())
        editText5.setText(GlobalVariables.Stime.toString())
        editText6.setText(GlobalVariables.Duratin.toString())
        editText7.setText(GlobalVariables.num.toString())
        editText8.setText(GlobalVariables.timeout.toString())

        button.setOnClickListener {
            var string1 = editText1.text.toString()
            if (string1.isNotEmpty()) {
                GlobalVariables.FromX = string1.toFloat()
            } else {
                editText1.setText(GlobalVariables.FromX.toString())
            }

            var string2 = editText2.text.toString()
            if (string2.isNotEmpty()) {
                GlobalVariables.FromY = string2.toFloat()
            } else {
                editText2.setText(GlobalVariables.FromY.toString())
            }

            var string3 = editText3.text.toString()
            if (string3.isNotEmpty()) {
                GlobalVariables.ToX = string3.toFloat()
            } else {
                editText3.setText(GlobalVariables.ToX.toString())
            }

            var string4 = editText4.text.toString()
            if (string4.isNotEmpty()) {
                GlobalVariables.ToY = string4.toFloat()
            } else {
                editText4.setText(GlobalVariables.ToY.toString())
            }

            var string5 = editText5.text.toString()
            if (string5.isNotEmpty()) {
                GlobalVariables.Stime = string5.toLong()
            } else {
                editText5.setText(GlobalVariables.Stime.toString())
            }

            var string6 = editText6.text.toString()
            if (string6.isNotEmpty()) {
                GlobalVariables.Duratin = string6.toLong()
            } else {
                editText6.setText(GlobalVariables.Duratin.toString())
            }

            var string7 = editText7.text.toString()
            if (string7.isNotEmpty()) {
                GlobalVariables.num = string7.toInt()
            } else {
                editText7.setText(GlobalVariables.num.toString())
            }

            var string8 = editText8.text.toString()
            if (string8.isNotEmpty()) {
                GlobalVariables.timeout = string8.toLong()
            } else {
                editText8.setText(GlobalVariables.timeout.toString())
            }
        }

        button1.setOnClickListener {
            if (GlobalVariables.flag == 0) {
                GlobalVariables.flag = 1
                button1.text = "start"
            } else {
                GlobalVariables.flag = 0
                button1.text = "stop"
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}