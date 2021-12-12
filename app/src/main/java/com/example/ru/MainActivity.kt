package com.example.ru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ru.lab_http_adapter.HttpActivity
import com.example.ru.lab_intent.IntentActivity
import com.example.ru.lab_sensors.SensorsActivity
import com.example.ru.lab_webview.WebViewActivity

class MainActivity : AppCompatActivity() {
    private lateinit var intent: Button
    private lateinit var http: Button
    private lateinit var web: Button
    private lateinit var sqlite: Button
    private lateinit var sensor: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        intent = findViewById(R.id.intent)
        web = findViewById(R.id.web)
        http = findViewById(R.id.http)
        sensor = findViewById(R.id.sensors)

        intent.setOnClickListener{
           val intent = Intent(this@MainActivity, IntentActivity::class.java)
            startActivity(intent)
        }

        http.setOnClickListener{
            val intent = Intent(this@MainActivity, HttpActivity::class.java)
            startActivity(intent)
        }

        web.setOnClickListener{
            val intentWebView = Intent(this, WebViewActivity::class.java)
            startActivity(intentWebView)
        }

        //sqlite.setOnClickListener{}

        sensor.setOnClickListener{
            val intent = Intent(this@MainActivity, SensorsActivity::class.java)
            startActivity(intent)
        }
    }
}