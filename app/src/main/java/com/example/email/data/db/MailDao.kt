package com.example.email.data.db

import androidx.room.Dao
import androidx.room.Insert
import com.example.email.data.model.MailModel

@Dao
interface MailDao {

    @Insert
    suspend fun addMail(mail : MailModel)
}