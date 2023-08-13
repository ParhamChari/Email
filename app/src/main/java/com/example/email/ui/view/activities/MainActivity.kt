package com.example.email.ui.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.email.data.db.MailDatabase
import com.example.email.data.repository.MailRepository
import com.example.email.databinding.ActivityMainBinding
import com.example.email.ui.viewmodel.MailViewModel
import com.example.email.ui.viewmodel.factory.MailViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mailViewModel: MailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewModel()
    }

    private fun setViewModel() {
        val mailRepository = MailRepository(
            MailDatabase(applicationContext)
        )

        val viewModelProviderFactory =
            MailViewModelFactory(
                application, mailRepository
            )

        mailViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory
        )[MailViewModel::class.java]

    }
}