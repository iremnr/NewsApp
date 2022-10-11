package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.databinding.KategoriRecycleRowBinding
import com.example.newsapp.model.Kategori

//(val kategoriList : ArrayList<Kategori>)

class KategoriGridAdapter: RecyclerView.Adapter<KategoriGridAdapter.KategoriViewHolder>(){

    var kategoriList = ArrayList<String>()
    fun initList() {
        kategoriList.add("all")
        kategoriList.add("national //Indian News only")
        kategoriList.add("business")
        kategoriList.add("sports")
        kategoriList.add("world")
        kategoriList.add("politics")
        kategoriList.add("technology")
        kategoriList.add("startup")
        kategoriList.add("entertainment")
        kategoriList.add("miscellaneous")
        kategoriList.add("hatke")
        kategoriList.add("science")
        kategoriList.add("automobile")
    }
    //val kategoriList = ArrayList<Kategori>()

    class KategoriViewHolder(val binding : KategoriRecycleRowBinding) : RecyclerView.ViewHolder(binding.root) {
        //val textView : TextView = itemView.findViewById(R.id.kateori_rwText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriViewHolder {
        //return KategoriViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.kategori_recycle_row,parent,false))

        //val view = DataBindingUtil.inflate<KategoriRecycleRowBinding>(LayoutInflater.from(parent.context),R.layout.kategori_recycle_row, parent,false)
        //return KategoriViewHolder(view)
        return KategoriViewHolder(KategoriRecycleRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: KategoriViewHolder, position: Int) {
        //holder.textView.text = kategoriList.get(position).category

        holder.binding.kateoriRwText.text = kategoriList[position]
    }

    override fun getItemCount(): Int {
        return kategoriList.size
    }

    //fun kategoriListGuncelle(newKategoriList: List<Kategori>) {
     ///   kategoriList.clear()
       // kategoriList.addAll(newKategoriList)
       // notifyDataSetChanged()
    //}
}




