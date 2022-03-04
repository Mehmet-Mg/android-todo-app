package com.example.myapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.entity.Yapilacaklar

@Database(entities = [Yapilacaklar::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun yapilacaklarDao() : YapilacaklarDao

    companion object {
        var INSTANCE: Veritabani? = null

        fun veritabaniErisim(context: Context) : Veritabani? {
            if(INSTANCE == null) {
                synchronized(Veritabani::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        Veritabani::class.java,
                        "todo.sqlite")
                        .createFromAsset("todo.sqlite")
                        .build()
                }
            }
            return INSTANCE
        }
    }
}