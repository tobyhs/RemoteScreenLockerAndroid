package io.github.tobyhs.remotescreenlocker.android.app

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Application subclass
 */
class App : DaggerApplication() {
    public override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.factory().create(AppModule(this))
    }
}
