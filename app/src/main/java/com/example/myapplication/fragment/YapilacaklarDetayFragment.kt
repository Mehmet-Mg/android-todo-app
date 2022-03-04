package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentYapilacaklarDetayBinding
import com.example.myapplication.viewmodel.YapilacakDetayFragmentViewModel
import com.example.myapplication.viewmodel.YapilacakDetayVMF
import com.example.myapplication.viewmodel.YapilacakKayitFragmentViewModel

class YapilacaklarDetayFragment : Fragment() {
    private lateinit var tasarim : FragmentYapilacaklarDetayBinding
    private lateinit var viewModel: YapilacakDetayFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_yapilacaklar_detay, container, false)
        tasarim.yapilacakDetayFragment = this
        tasarim.yapilacakDetayToolbarBaslik = "Yapılacak Detay"

        val bundle: YapilacaklarDetayFragmentArgs by navArgs()
        val gelenYapilacak = bundle.yapilacak

        tasarim.yapilacakNesnesi = gelenYapilacak

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : YapilacakDetayFragmentViewModel by viewModels(){
            YapilacakDetayVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonGuncelleTikla(yapilacak_id : Int, yapilacak_isim: String) {
        viewModel.guncelle(yapilacak_id, yapilacak_isim)
    }
}