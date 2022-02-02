package com.example.tiltsensor

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager

class MainActivity : AppCompatActivity(), SensorEventListener {

    private val sensorManager by lazy {
        getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }
    private lateinit var tiltView: TiltView

    override fun onCreate(savedInstanceState: Bundle?) {
        // 화면이 꺼지지 않게 하기
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        // 화면 가로모드로 고정
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        super.onCreate(savedInstanceState)

        tiltView = TiltView(this)
        setContentView(tiltView)
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        TODO("Not yet implemented")
        // 센서값이 변경되면 호출됨
        // value[0] : x축 값 : 위로 기울이면 -10~0, 아래로 기울이면 0~10
        // value[1] : y축 값 : 왼쪽으로 기울이면 -10~0, 아래로 기울이면 0~10
        // value[2] : z축 값 : 미사용
        event?.let {
            Log.d("MainActivity", "onSensorChanged: x :" + " ${event.values[0]}, y : ${event.values[1]}, z : ${event.values[2]}")
        }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("Not yet implemented")
    }

    // 화면 꺼지기 직전에 센서를 해제
    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

}