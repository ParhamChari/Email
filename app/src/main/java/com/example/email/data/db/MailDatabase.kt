package com.example.email.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.email.data.model.MailModel

@Database(entities = [MailModel::class], version = 1)
abstract class MailDatabase : RoomDatabase() {

    abstract fun getMailDao() : MailDao


    companion object {
        @Volatile
        private var instance: MailDatabase? = null
        private val lock = Any()
        operator fun invoke(context: Context): MailDatabase {
            return instance ?: synchronized(lock) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
            context.applicationContext,
            MailDatabase::class.java,
            "MailDb"
        ).build()

    }

}