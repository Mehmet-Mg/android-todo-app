package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CardTasarimiBinding
import com.example.myapplication.entity.Yapilacaklar
import com.example.myapplication.fragment.AnasayfaFragmentDirections
import com.example.myapplication.viewmodel.AnasayfaFragmentViewModel
import com.google.android.material.snackbar.Snackbar

class YapilacaklarAdapter(var mContext: Context, var yapilacaklarListesi: List<Yapilacaklar>, var viewModel: AnasayfaFragmentViewModel) :
    RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(tasarim: CardTasarimiBinding) : RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: CardTasarimiBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimiBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacak = yapilacaklarListesi.get(position)
        val t = holder.tasarim
        t.yapilacakNesnesi = yapilacak
        t.satirCard.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.gecisDetay(yapilacak)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it, "${yapilacak.yapilacak_isim} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET"){ viewModel.sil(yapilacak.yapilacak_id) }.show()
        }
    }

    override fun getItemCount(): Int {
        return yapilacaklarListesi.size
    }
}