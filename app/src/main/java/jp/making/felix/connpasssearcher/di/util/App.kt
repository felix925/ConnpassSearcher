package jp.making.felix.connpasssearcher.di.util

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import jp.making.felix.connpasssearcher.di.DaggerAppComponent

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        AppInjector.initialize(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}