package com.enessaidokur.filmlerapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.enessaidokur.filmlerapp.R
import com.enessaidokur.filmlerapp.data.entity.Filmler
import com.enessaidokur.filmlerapp.databinding.CardTasarimBinding
import com.enessaidokur.filmlerapp.databinding.FragmentAnasayfaBinding
import com.enessaidokur.filmlerapp.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter(var mContext: Context,var filmlerListesi : List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>()
{

inner class CardTasarimTutucu(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
val binding:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim,parent, false)
 return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmlerListesi.get(position)
        val t = holder.tasarim
        t.imageViewFilm.setImageResource(
            mContext.resources.getIdentifier(film.resim,"drawable",mContext.packageName)
        )
        t.filmNesnesi = film

        t.cardViewFilm.setOnClickListener {
           val gecis = AnasayfaFragmentDirections.detayGecis(film = film)
            Navigation.findNavController(it).navigate(gecis)
        }
        t.buttonSepet.setOnClickListener {
            Snackbar.make(it,"${film.fiyat} ₺",Snackbar.LENGTH_SHORT).show()
        }
    }
    override fun getItemCount(): Int {
       return filmlerListesi.size
    }
}