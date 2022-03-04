package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.entity.Yapilacaklar
import com.example.myapplication.repo.YapilacaklarRepo

class AnasayfaFragmentViewModel(application: Application) : AndroidViewModel(application) {
    var yapilacaklarListesi = MutableLiveData<List<Yapilacaklar>>()
    val yrepo = YapilacaklarRepo(application)

    init {
        yapilacaklariYukle()
        yapilacaklarListesi = yrepo.yapilacaklariGetir()
    }

    fun ara(aramaKelimesi: String) {
        yrepo.yapilacakAra(aramaKelimesi)
    }

    fun sil(yapilacak_id: Int) {
        yrepo.yapilacakSil(yapilacak_id)
    }

    fun yapilacaklariYukle() {
        yrepo.tumYapilacaklariAl()
    }
}