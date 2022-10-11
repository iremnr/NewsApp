package com.example.newsapp.view

import android.os.Bundle
import android.provider.Settings.Global.getString
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapter.KategoriGridAdapter
import com.example.newsapp.databinding.FragmentKategoriListBinding
import com.example.newsapp.viewmodel.KategoriListViewModel
import retrofit2.http.GET


class KategoriListFragment : Fragment() {

        lateinit var viewModel : KategoriListViewModel
        lateinit var binding: FragmentKategoriListBinding

        private val kategoriRecyclerAdapter : KategoriGridAdapter by lazy { KategoriGridAdapter() }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = FragmentKategoriListBinding.inflate(layoutInflater)
            val view=binding.root

         }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_kategori_list, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)


            //var cName = GET.getString("categoryName", "all")
            viewModel = ViewModelProvider(this).get(KategoriListViewModel::class.java)
            viewModel.refreshData()

            //val recyclerView : RecyclerView = view.findViewById(R.id.recyclerView)
            binding.recyclerView.adapter = kategoriRecyclerAdapter
            binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
            //val adapter = KategoriGridAdapter(category)


            observeData()

        }

        fun observeData() {
            viewModel.kategoriler.observe(viewLifecycleOwner, Observer {
                    kategoriler ->
                    kategoriler?.let {
                        binding.recyclerView.visibility = View.VISIBLE
                        //kategoriRecyclerAdapter.kategoriListGuncelle(kategoriler)
                }
            })

            viewModel.errorMessage.observe(viewLifecycleOwner, Observer { error->
                error?.let {
                    if(it){
                        binding.kategoriListHataMesaji.visibility= View.VISIBLE
                        binding.recyclerView.visibility=View.GONE
                    } else {
                        binding.kategoriListHataMesaji.visibility = View.GONE
                    }
                }
            })

            viewModel.categoryUploading.observe(viewLifecycleOwner, Observer { uploading ->
                uploading?.let {
                    if(it){
                        binding.kategoriProgressBar.visibility=View.VISIBLE
                        binding.kategoriListHataMesaji.visibility = View.GONE
                        binding.recyclerView.visibility=View.GONE
                    } else {
                        binding.recyclerView.visibility=View.GONE
                    }
                }
            })

    }
}
