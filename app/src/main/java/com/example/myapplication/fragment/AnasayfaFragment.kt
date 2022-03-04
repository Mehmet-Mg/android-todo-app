package com.example.myapplication.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.adapter.YapilacaklarAdapter
import com.example.myapplication.databinding.FragmentAnasayfaBinding
import com.example.myapplication.viewmodel.AnasayfaFragmentViewModel
import com.example.myapplication.viewmodel.AnasayfaVMF

class AnasayfaFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var tasarim: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)

        tasarim.anasayfaFragment = this
        tasarim.anasayfaToolbarBaslik = "Yapılacaklar"

        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        viewModel.yapilacaklarListesi.observe(viewLifecycleOwner, {
            val adapter = YapilacaklarAdapter(requireContext(), it, viewModel)
            tasarim.yapilacaklarAdapter = adapter
        })
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AnasayfaFragmentViewModel by viewModels() {
            AnasayfaVMF(requireActivity().application)
        }
        viewModel = tempViewModel
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(p0: String): Boolean {
        viewModel.ara(p0)
        return true
    }

    override fun onQueryTextChange(p0: String): Boolean {
        viewModel.ara(p0)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.yapilacaklariYukle()
    }

    fun fabTikla(v: View) {
        Navigation.findNavController(v).navigate(R.id.gecisKayit)
    }
}