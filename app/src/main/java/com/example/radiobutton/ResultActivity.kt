package com.example.radiobutton

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    private lateinit var resultPointsTV: TextView
    private lateinit var resultTV: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        resultPointsTV = findViewById(R.id.resultPointsTV)
        resultTV = findViewById(R.id.resultTV)

        val result = intent.getIntExtra("result", 0)

        resultPointsTV.text = "У Вас $result баллов!"
        when (result) {
            0 -> resultTV.text = getString(R.string.result0)
            100 -> resultTV.text = getString(R.string.result100)
            200 -> resultTV.text = getString(R.string.result200)
            300 -> resultTV.text = getString(R.string.result300)
            400 -> resultTV.text = getString(R.string.result400)
            500 -> resultTV.text = getString(R.string.result500)
        }
    }
}