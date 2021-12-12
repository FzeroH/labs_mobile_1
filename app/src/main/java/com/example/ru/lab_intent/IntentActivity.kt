package com.example.ru.lab_intent

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import com.example.ru.R

class IntentActivity : AppCompatActivity() {
    private val REQUEST_TAKE_PHOTO = 1
    private var savePhoto: Bitmap? = null
    private val IMG: String = "IMG"

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        imageView = findViewById(R.id.image_view)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(IMG, savePhoto)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savePhoto = savedInstanceState.getParcelable(IMG)
        
        imageView.setImageBitmap(savePhoto as Bitmap)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {

            val image = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(image)
            savePhoto = image

        }
    }
}