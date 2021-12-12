package com.example.ru.lab_webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.ru.R

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val web: WebView = findViewById(R.id.web_view)

        web.webViewClient = WebViewClient()
        web.apply{
            loadUrl("file:///android_asset/www/main.html")
        }

    }
}