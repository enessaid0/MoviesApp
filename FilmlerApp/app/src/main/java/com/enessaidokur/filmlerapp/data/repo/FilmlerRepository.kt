package com.enessaidokur.filmlerapp.data.repo

import com.enessaidokur.filmlerapp.data.entity.Filmler
import com.enessaidokur.filmlerapp.data.entity.datasource.FilmlerDataSource

class FilmlerRepository(var fds : FilmlerDataSource) {

    suspend fun filmleriYukle():List<Filmler> = fds.filmleriYukle()
}