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

class FirstQuestion : AppCompatActivity() {

    private lateinit var answersRG: RadioGroup
    private lateinit var answerOne: RadioButton
    private lateinit var answerTwo: RadioButton
    private lateinit var answerThree: RadioButton
    private var result: Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        answersRG = findViewById(R.id.answersFirstRG)
        answerOne = findViewById(R.id.answerFirstOne)
        answerTwo = findViewById(R.id.answerFirstTwo)
        answerThree = findViewById(R.id.answerFirstThree)

        answerOne.setOnClickListener(answerClickListener)
        answerTwo.setOnClickListener(answerClickListener)
        answerThree.setOnClickListener(answerClickListener)

    }

    private val answerClickListener = View.OnClickListener { v: View? ->
        when (v?.id) {
            R.id.answerFirstOne -> {
                CoroutineScope(Dispatchers.Main).launch {
                    wrong() }
            }
            R.id.answerFirstTwo -> {
                CoroutineScope(Dispatchers.Main).launch {
                    write() }
            }
            R.id.answerFirstThree -> {
                CoroutineScope(Dispatchers.Main).launch {
                    wrong() }
            }
        }
    }

    private suspend fun wrong() {
        answersRG.setBackgroundColor(Color.RED)
        delay(250L)
        val result = 0
        val intent = Intent(this, SecondQuestion::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }
    private suspend fun write() {
        answersRG.setBackgroundColor(Color.GREEN)
        delay(250L)
        val result = 100
        val intent = Intent(this, SecondQuestion::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }
}