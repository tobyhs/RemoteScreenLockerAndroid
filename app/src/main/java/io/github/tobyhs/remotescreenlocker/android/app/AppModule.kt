package io.github.tobyhs.remotescreenlocker.android.app

import com.github.tobyhs.rxsecretary.SchedulerProvider
import com.github.tobyhs.rxsecretary.android.AndroidSchedulerProvider

import dagger.Module
import dagger.Provides

import javax.inject.Singleton

/**
 * Dagger module that provides main dependencies
 */
@Module
class AppModule(private val app: App) {
    /**
     * @return App instance
     */
    @Provides
    @Singleton
    fun provideApp(): App = app

    /**
     * @return RxJava scheduler provider
     */
    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider = AndroidSchedulerProvider()
}
