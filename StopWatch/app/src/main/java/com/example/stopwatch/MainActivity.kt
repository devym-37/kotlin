package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private var time = 0
    private var isRunning = false
    private var timerTask: Timer? = null
    private var fab: View = findViewById(R.id.floatingActionButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            isRunning = !isRunning

            if (isRunning) {
                start()
            } else {
                pause()
            }
        }
    }



    private fun start() {
        fab.setImageResource(R.drawable.ic_baseline_pause_24)

        timerTask = timer(period = 10){
            time++
            val sec = time / 100
            val millisec = time % 100
            runOnUiThread {
                secTextView.text = "$sec"
                milliTextView.text = "$millisec"
            }
        }
    }

    private fun pause() {
        fab.setImageResource(R.drawable.ic_baseline_play_arrow_24)
        timerTask?.cancel()
    }
}