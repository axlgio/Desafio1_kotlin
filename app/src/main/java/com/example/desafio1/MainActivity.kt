package com.example.desafio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafio1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val sheratonHotel = "https://turismo.org/hoteles-en-egipto/"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnReserva.setOnClickListener {
            startActivity(Intent(this, ActivityReserva::class.java))
        }


        hotelsitio()




    }


    private fun hotelsitio() {

        val intent = Intent(this, WebViewActivity::class.java)
        val key = "url"
        binding.apply {
            btnSitio.setOnClickListener {
                intent.putExtra(key, sheratonHotel)
                startActivity(intent)
            }


        }


    }

}