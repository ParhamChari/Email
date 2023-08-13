package com.example.email.ui.viewmodel.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.email.data.repository.MailRepository
import com.example.email.ui.viewmodel.MailViewModel

@Suppress("UNCHECKED_CAST")
class MailViewModelFactory(val app : Application, private val repository: MailRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MailViewModel(app, repository) as T
    }
}