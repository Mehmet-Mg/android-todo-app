package com.example.myapplication.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "yapilacaklar")
data class Yapilacaklar(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "yapilacak_id") @NotNull val yapilacak_id: Int,
    @ColumnInfo(name = "yapilacak_isim") @NotNull val yapilacak_isim: String) : Serializable {
}