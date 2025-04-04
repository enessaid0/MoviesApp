package com.enessaidokur.filmlerapp.di

import android.content.Context
import androidx.room.Room
import com.enessaidokur.filmlerapp.data.entity.datasource.FilmlerDataSource
import com.enessaidokur.filmlerapp.data.repo.FilmlerRepository
import com.enessaidokur.filmlerapp.room.FilmlerDao
import com.enessaidokur.filmlerapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFilmlerDataSource(fdao:FilmlerDao): FilmlerDataSource{
        return FilmlerDataSource(fdao)
    }
    @Provides
    @Singleton
    fun provideFilmlerRepository(fds:FilmlerDataSource): FilmlerRepository {
        return FilmlerRepository(fds)
    }
    @Provides
    @Singleton
    fun provideFilmlerDao(@ApplicationContext context: Context): FilmlerDao{
        val vt = Room.databaseBuilder(context,Veritabani::class.java
   ,"filmler_app.sqlite").createFromAsset("filmler_app.sqlite").build()

        return vt.getFilmlerDao()

}}