package jp.making.felix.connpasssearcher.di

import android.app.Application

interface AppInitializer {
    fun initialize(application: Application)
}
