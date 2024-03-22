package com.example.oceanjornadaandroidmar2024.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oceanjornadaandroidmar2024.R
import com.example.oceanjornadaandroidmar2024.viewmodel.ItemViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvItens = findViewById<RecyclerView>(R.id.rvItens)
        rvItens.layoutManager = LinearLayoutManager(this)

//        rvItens.layoutManager = GridLayoutManager(this, 2)

        val itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        itemViewModel.itens.observe(this) {
            rvItens.adapter = ItemAdapter(it)
        }
    }
}
