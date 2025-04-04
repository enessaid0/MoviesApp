package com.enessaidokur.filmlerapp.room

import androidx.room.Dao
import androidx.room.Query
import com.enessaidokur.filmlerapp.data.entity.Filmler

@Dao
interface FilmlerDao {

    @Query("SELECT * FROM filmler")
    suspend fun filmleriYukle() : List<Filmler>

}