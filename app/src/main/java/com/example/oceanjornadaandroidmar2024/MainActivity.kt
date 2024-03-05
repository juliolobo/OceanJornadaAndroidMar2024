package com.example.oceanjornadaandroidmar2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val etNome = findViewById<EditText>(R.id.etNome)

        btEnviar.setOnClickListener {
            val nome = etNome.text.toString()
            if(nome.isNotEmpty()) {
                tvResultado.text = nome
            } else {
                etNome.error = "Preencha o campo"
            }
        }
    }
}