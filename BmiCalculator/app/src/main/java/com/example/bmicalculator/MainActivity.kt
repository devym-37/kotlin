package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

// viewBinding

class MainActivity : AppCompatActivity() {
    private fun saveData(height: Int, weight: Int){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putInt("KEY_HEIGHT", height)
            .putInt("KEY_WEIGHT", weight)
            .apply()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultButton.setOnClickListener {
            //  결과 버튼이 클릭되면 실행
            // val intent = Intent(this, ResultActivity::class.java)
            // intent.putExtra("weight", weightEditText.text.toString())
            // intent.putExtra("height", heightEditText.text.toString())

            // startActivity(intent)

            startActivity<ResultActivity>(
                "weight" to weightEditText.text.toString(),
                "height" to heightEditText.text.toString()
            )
        }
    }


}