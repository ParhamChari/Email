package com.example.email.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.email.data.model.MailModel
import com.example.email.data.repository.MailRepository
import kotlinx.coroutines.launch

class MailViewModel(app : Application, private val repository: MailRepository) : AndroidViewModel(app) {

    fun addMail(mail : MailModel) = viewModelScope.launch {
        repository.addMail(mail)
    }
}