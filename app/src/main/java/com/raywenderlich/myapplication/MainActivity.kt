package com.raywenderlich.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import com.raywenderlich.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val DELTA_VALUE = 9

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initView()
        Log.e("hahaha", "$DELTA_VALUE")
    }

    private fun initView() {
        binding.apply {
            seekbarTest.apply {
                progress = 25
                setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                    // When Progress value changed.
                    override fun onProgressChanged(
                        seekbar: SeekBar?,
                        progressValue: Int,
                        isFromUser: Boolean
                    ) {
                        Log.e("hahaha", "onProgressChanged")
                        textviewSeekbarProgress.text = "$progressValue"
                    }

                    // Notification that the user has started a touch gesture.
                    override fun onStartTrackingTouch(seekbar: SeekBar?) {
                        Log.e("hahaha", "onStartTrackingTouch")
                    }

                    // Notification that the user has finished a touch gesture
                    override fun onStopTrackingTouch(seekbar: SeekBar?) {
                        Log.e("hahaha", "onStopTrackingTouch")
                    }
                })
            }
            increaseSeekbar.setOnClickListener { increaseProgress() }
            decreaseSeekbar.setOnClickListener { decreaseProgress() }
        }
    }

    private fun decreaseProgress() {
        val progress: Int = binding.seekbarTest.progress
        if (progress - DELTA_VALUE < 0) {
            binding.seekbarTest.progress = 0
        } else {
            binding.seekbarTest.progress = progress - DELTA_VALUE
        }
        binding.textviewSeekbarProgress.text =
            "Progress: ${binding.seekbarTest.progress}/${binding.seekbarTest.max}"
    }

    private fun increaseProgress() {
        val progress: Int = binding.seekbarTest.progress
        if (progress + DELTA_VALUE > binding.seekbarTest.max) {
            binding.seekbarTest.progress = binding.seekbarTest.max
        } else {
            binding.seekbarTest.progress = progress + DELTA_VALUE
        }
        binding.textviewSeekbarProgress.text =
            "Progress: ${binding.seekbarTest.progress}/${binding.seekbarTest.max}"
    }

}