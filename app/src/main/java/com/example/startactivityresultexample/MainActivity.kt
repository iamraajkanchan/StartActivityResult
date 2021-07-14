package com.example.startactivityresultexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val action = registerForActivityResult(ActivityResultContracts.GetContent() , ActivityResultCallback { uri ->
            img_profile.setImageURI(uri)
        })

        bt_selectImage.setOnClickListener {
            action.launch("image/*")
        }
    }
}

/*
https://developer.android.com/training/sharing/send

text/plain, text/rtf, text/html, text/json, receivers should register for text/*
image/jpg, image/png, image/gif, receivers should register for image/*
video/mp4, video/3gp, receivers should register for video/*
application/pdf, receivers should register for supported file extensions
You can use a MIME type of */*, but this is highly discouraged and will only match activities that are able to handle generic data streams.

*/