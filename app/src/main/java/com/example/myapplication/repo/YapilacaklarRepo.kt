package com.example.myapplication.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.entity.Yapilacaklar
import com.example.myapplication.room.Veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YapilacaklarRepo(var application: Application) {
    var yapilacaklarListesi: MutableLiveData<List<Yapilacaklar>>
    var vt: Veritabani

    init {
        yapilacaklarListesi = MutableLiveData()
        vt = Veritabani.veritabaniErisim(application)!!
    }

    fun yapilacaklariGetir() : MutableLiveData<List<Yapilacaklar>> {
        return yapilacaklarListesi
    }

    fun yapilacakKayit(yapilacak_isim: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            vt.yapilacaklarDao().yapilacakEkle(Yapilacaklar(0, yapilacak_isim))
        }
    }

    fun yapilacakGuncelle(yapilacak_id: Int, yapilacak_isim: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            vt.yapilacaklarDao().yapilacakGuncelle(Yapilacaklar(yapilacak_id, yapilacak_isim))
        }
    }

    fun yapilacakAra(aramaKelimesi: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = vt.yapilacaklarDao().yapilacakArama(aramaKelimesi)
        }
    }

    fun yapilacakSil(yapilacak_id: Int) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            vt.yapilacaklarDao().yapilacakSil(Yapilacaklar(yapilacak_id, ""))
            tumYapilacaklariAl()
        }
    }

    fun tumYapilacaklariAl() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = vt.yapilacaklarDao().tumYapilacaklar()
        }
    }
}