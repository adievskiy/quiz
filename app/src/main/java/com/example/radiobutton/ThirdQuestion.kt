package com.example.radiobutton

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.*

class ThirdQuestion : AppCompatActivity() {

    private lateinit var answersRG: RadioGroup
    private lateinit var answerOne: RadioButton
    private lateinit var answerTwo: RadioButton
    private lateinit var answerThree: RadioButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        answersRG = findViewById(R.id.answersThirdRG)
        answerOne = findViewById(R.id.answerThirdOne)
        answerTwo = findViewById(R.id.answerThirdTwo)
        answerThree = findViewById(R.id.answerThirdThree)

        answerOne.setOnClickListener(answerClickListener)
        answerTwo.setOnClickListener(answerClickListener)
        answerThree.setOnClickListener(answerClickListener)

    }
    private val answerClickListener = View.OnClickListener { v: View? ->
        when (v?.id) {
            R.id.answerThirdOne -> {
                CoroutineScope(Dispatchers.Main).launch {
                    wrong() }
            }
            R.id.answerThirdTwo -> {
                CoroutineScope(Dispatchers.Main).launch {
                    wrong() }
            }
            R.id.answerThirdThree -> {
                CoroutineScope(Dispatchers.Main).launch {
                    write() }
            }
        }
    }

    private suspend fun wrong() {
        answersRG.setBackgroundColor(Color.RED)
        delay(250L)
        val result = intent.getIntExtra("result", 0)
        val intent = Intent(this, FourthQuestion::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }
    private suspend fun write() {
        answersRG.setBackgroundColor(Color.GREEN)
        delay(250L)
        val result = intent.getIntExtra("result", 0)
        val resultUpd = result + 100
        val intent = Intent(this, FourthQuestion::class.java)
        intent.putExtra("result", resultUpd)
        startActivity(intent)
    }
}