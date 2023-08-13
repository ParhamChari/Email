package com.example.email.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "mails_table")
@Parcelize
data class MailModel(
    @PrimaryKey(autoGenerate = true) val id : Int,
    val userEmail : String,
    val userPassword : String
) :Parcelable
