package com.example.desafio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.desafio1.databinding.ActivityReservaBinding
import com.google.android.material.snackbar.Snackbar

class ActivityReserva : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var binding: ActivityReservaBinding

    val optiones = arrayListOf("Habitacion Comun","Habitacion con vista", "Suite con terraza" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val spinnerAdapter = ArrayAdapter(
            this,
            R.layout.support_simple_spinner_dropdown_item,
            optiones
        )

        binding.spinnerReserva.apply {

            adapter = spinnerAdapter
            setSelection(0, true)
            onItemSelectedListener = this@ActivityReserva

            confirmar()

        }

    }


    private fun confirmar(){

        binding.btnReserva.setOnClickListener {

            var message = "Nombre: ${binding.etName.text} "+
                    "Apellido: ${binding.etApellido.text} "+
                    "Reservacion: ${binding.spinnerReserva.selectedItem}"


            if (binding.etName.text.isBlank()) {
                message = "Name field is empty"

            } else if (binding.etApellido.text.isBlank()) {
                message = "Apellido field is empty"

            }

            Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show()

        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}