package com.example.gallery

import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAllPhotos()
    }

    // 전체 사진 가져오기
    private fun getAllPhotos() {
        // 두번째 가져올 항목 배열, 조건, 조건, 찍은 날짜 내림차
        val cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC")
    }
}