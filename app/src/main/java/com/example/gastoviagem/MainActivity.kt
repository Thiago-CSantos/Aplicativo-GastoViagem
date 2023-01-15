package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(click: View) {
        if (click.id == R.id.button_calculate) {
            calculate()
        }
    }


    private fun validar(): Boolean {
        if (binding.editDistance.text.toString() != ""
            && binding.editPrice.text.toString() != ""
            && binding.editAutonomy.text.toString() != ""
            && binding.editAutonomy.text.toString().toFloat() != 0f) {
            return true
        }
        else {
            return false
        }
    }

    private fun calculate(): Unit {

        if (validar()) {

            var distancia = binding.editDistance.text.toString().toFloat()
            var preco = binding.editPrice.text.toString().toFloat()
            var autonomia = binding.editAutonomy.text.toString().toFloat()

            var valorTotal = (distancia * preco) / autonomia

            binding.textTotalValue.text = valorTotal.toString()
        } else {
            Toast.makeText(applicationContext, "Preencha todos os campos", Toast.LENGTH_LONG).show()
        }

    }
}