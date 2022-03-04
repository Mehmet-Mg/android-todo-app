package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentYapilacaklarKayitBinding
import com.example.myapplication.viewmodel.YapilacakKayitFragmentViewModel
import com.example.myapplication.viewmodel.YapilacakKayitVMF

class YapilacaklarKayitFragment : Fragment() {
    private lateinit var tasarim: FragmentYapilacaklarKayitBinding
    private lateinit var viewModel: YapilacakKayitFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_yapilacaklar_kayit, container, false)
        tasarim.yapilacakKayitFragment = this
        tasarim.yapilacakKayitToolbarBaslik = "Yapılacak Kayıt"

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: YapilacakKayitFragmentViewModel by viewModels(){
            YapilacakKayitVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonKaydetTikla(yapilacak_isim: String) {
        viewModel.kayit(yapilacak_isim)
    }
}