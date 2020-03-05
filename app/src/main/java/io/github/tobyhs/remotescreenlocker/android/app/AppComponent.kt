package io.github.tobyhs.remotescreenlocker.android.app

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

import javax.inject.Singleton

/**
 * Dagger component for App
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    /**
     * Factory to create an AppComponent
     */
    @Component.Factory
    interface Factory {
        /**
         * @param appModule module to provide dependencies of App
         * @return Dagger component for App
         */
        fun create(appModule: AppModule): AppComponent
    }
}
