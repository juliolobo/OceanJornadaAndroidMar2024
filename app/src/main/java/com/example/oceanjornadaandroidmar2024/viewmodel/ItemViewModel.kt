package com.example.oceanjornadaandroidmar2024.viewmodel

import androidx.lifecycle.ViewModel
import com.example.oceanjornadaandroidmar2024.model.api.ApiRepository

class ItemViewModel : ViewModel() {
    val itens = ApiRepository.itens
}