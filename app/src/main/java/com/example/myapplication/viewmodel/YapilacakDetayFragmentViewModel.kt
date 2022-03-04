package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.myapplication.repo.YapilacaklarRepo

class YapilacakDetayFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val yrepo = YapilacaklarRepo(application)

    fun guncelle(yapilacak_id: Int, yapilacak_isim: String) {
        yrepo.yapilacakGuncelle(yapilacak_id, yapilacak_isim)
    }
}