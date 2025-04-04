package com.enessaidokur.filmlerapp.data.entity.datasource

import com.enessaidokur.filmlerapp.data.entity.Filmler
import com.enessaidokur.filmlerapp.room.FilmlerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmlerDataSource(var fdao : FilmlerDao) {

    suspend fun filmleriYukle():List<Filmler> =
    withContext(Dispatchers.IO) {

        return@withContext fdao.filmleriYukle()

    }}

