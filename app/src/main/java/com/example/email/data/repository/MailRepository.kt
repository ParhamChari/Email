package com.example.email.data.repository

import com.example.email.data.local.MailDatabase
import com.example.email.data.model.MailModel

class MailRepository(private val mailDatabase: MailDatabase) {

    suspend fun addMail(mail : MailModel) = mailDatabase.getMailDao().addMail(mail)
}