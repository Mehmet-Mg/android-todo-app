package com.example.myapplication.room

import androidx.room.*
import com.example.myapplication.entity.Yapilacaklar

@Dao
interface YapilacaklarDao {
    @Query("SELECT * FROM yapilacaklar")
    suspend fun tumYapilacaklar() : List<Yapilacaklar>

    @Insert
    suspend fun yapilacakEkle(yapilacak: Yapilacaklar)

    @Update
    suspend fun yapilacakGuncelle(yapilacak: Yapilacaklar)

    @Delete
    suspend fun yapilacakSil(yapilacak: Yapilacaklar)

    @Query("Select * from yapilacaklar where yapilacak_isim like '%' || :aramaKelimesi || '%'")
    suspend fun yapilacakArama(aramaKelimesi: String) : List<Yapilacaklar>
}