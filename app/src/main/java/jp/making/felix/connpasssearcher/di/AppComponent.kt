package jp.making.felix.connpasssearcher.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import jp.making.felix.connpasssearcher.di.module.AppModule
import jp.making.felix.connpasssearcher.di.util.App

@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}