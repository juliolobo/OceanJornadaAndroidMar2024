package com.example.oceanjornadaandroidmar2024.model.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.oceanjornadaandroidmar2024.model.domain.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRepository {
    val itens = MutableLiveData<List<Item>>()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ocean-api-itens.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        apiService.carregarItens().enqueue(object : Callback<Array<Item>> {
            override fun onResponse(call: Call<Array<Item>>, response: Response<Array<Item>>) {
                response.body()?.let {
                    itens.postValue(it.toList())
                }
            }

            override fun onFailure(call: Call<Array<Item>>, t: Throwable) {
                Log.e("API", "Erro ao carregar dados da API.", t)
            }

        })
    }
}