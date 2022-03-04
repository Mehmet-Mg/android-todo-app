package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.myapplication.repo.YapilacaklarRepo

class YapilacakKayitFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val yrepo = YapilacaklarRepo(application)

    fun kayit(yapilacak_isim: String) {
        yrepo.yapilacakKayit(yapilacak_isim)
    }
}