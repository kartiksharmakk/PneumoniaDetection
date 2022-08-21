package com.example.pneumoniadetection

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.example.pneumoniadetection.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var analyzer: Analyzer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        analyzer = Analyzer((this))
        initListeners()
    }

    private fun initListeners() {
        binding.buttonGallery.setOnClickListener {
            openGallery()
        }
    }
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        resultLauncher.launch(intent)
    }

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {

                val data: Intent? = result.data
                val uri = data?.data
                val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                binding.imageView.setImageBitmap(bitmap)
                classifyImage(bitmap)
            }
        }

    private fun classifyImage(bitmap: Bitmap?) {
        if (::analyzer.isInitialized) {
            bitmap?.let {
                binding.textName.text=analyzer.classify(it).resultName
                binding.textProbability.text=analyzer.classify(it).resultProbability.toString()
            }
        }
    }
}