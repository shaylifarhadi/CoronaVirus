package com.example.coronavs.di.module

import com.example.coronavs.network.ApiRepository
import com.example.coronavs.network.ApiRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModules {

    @Binds
    abstract fun provideApiRepository(apiRepositoryImp: ApiRepositoryImp): ApiRepository

}