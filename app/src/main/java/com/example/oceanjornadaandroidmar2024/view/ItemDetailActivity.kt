package com.example.oceanjornadaandroidmar2024.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.bumptech.glide.Glide
import com.example.oceanjornadaandroidmar2024.model.api.ApiService
import com.example.oceanjornadaandroidmar2024.model.domain.ItemDetail
import com.example.oceanjornadaandroidmar2024.R
import com.google.android.material.chip.Chip

class ItemDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val id = intent.getIntExtra("ID", 0)

        if (id == 0) {
            return finish()
        }

        val tvNome = findViewById<TextView>(R.id.tvNome)
        val ivImagem = findViewById<ImageView>(R.id.ivImagem)
        val chipStatus = findViewById<Chip>(R.id.chipStatus)
        val chipEspecie = findViewById<Chip>(R.id.chipEspecie)
        val chipGenero = findViewById<Chip>(R.id.chipGenero)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://ocean-api-itens.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        apiService.getById(id).enqueue(object : Callback<ItemDetail> {
            override fun onResponse(call: Call<ItemDetail>, response: Response<ItemDetail>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        tvNome.text = it.nome.toString()
                        chipStatus.text = it.status.toString()
                        chipEspecie.text = it.especie.toString()
                        chipGenero.text = it.genero.toString()
                        Glide.with(ivImagem).load(it.imagem).into(ivImagem)
                    }
                }
            }

            override fun onFailure(call: Call<ItemDetail>, t: Throwable) {
                Log.e("API", "Deu ruim.", t)
            }
        })
    }
}