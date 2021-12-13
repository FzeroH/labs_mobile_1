package com.example.ru.lab_http_adapter

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.ru.R
import okhttp3.*
import java.io.IOException

class HttpActivity : AppCompatActivity() {

    private val okHttpClient = OkHttpClient()
    private val request = Request.Builder()
        .url("https://www.google.ru")
        .get()
        .build()
    private lateinit var req: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        req = findViewById(R.id.req)

        val runnable = Runnable {
            fun run(){
                okHttpClient.newCall(request).enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        Log.d("TAG", e.message.toString())
                    }

                    override fun onResponse(call: Call, response: Response) {
                        println(" ДЕБАЖЫМ${response.message}")
                        //req.text = response.message
                    }
                })
            }
        }

        val thread = Thread(runnable)
        thread.start()

    }
}