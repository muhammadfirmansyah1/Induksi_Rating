package com.example.rating

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.rating.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var status = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSubmit.isEnabled = false

        handleRatingChange()
        handleTips()
        handleSubmit()
        handleReset()

    }

    private fun handleReset() {
        binding.apply {
            buttonReset.setOnClickListener{
                ratingBar.rating = 0.0F
            }
        }
    }

    private fun handleTips(){
        binding.apply {
            if(switch1.isChecked){
                status = "Tips Diberikan"
            } else {
                status = "Tips Tidak Diberikan"
            }
            switch1.setOnCheckedChangeListener { button, isChecked ->
             if(isChecked){
                 status = "Tips Diberikan"
             } else {
                 status = "Tips Tidak Diberikan"
             }
            }
        }
    }

    private fun handleRatingChange(){
        binding.apply {
            ratingBar.setOnRatingBarChangeListener{ _, rating,_ ->
                buttonSubmit.isEnabled = rating > 0.0F
            }
        }
    }

    private fun handleSubmit(){
        binding.apply {
            buttonSubmit.setOnClickListener{
                Toast.makeText(this@MainActivity, "Rating yang diberikan adalah " +
                        "${binding.ratingBar.rating.toString()} dengan status tips : $status" ,Toast.LENGTH_SHORT).show()
            }
        }
    }
}