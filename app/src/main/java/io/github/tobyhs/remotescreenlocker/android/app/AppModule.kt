package io.github.tobyhs.remotescreenlocker.android.app

import androidx.room.Room

import com.github.tobyhs.rxsecretary.SchedulerProvider
import com.github.tobyhs.rxsecretary.android.AndroidSchedulerProvider

import dagger.Module
import dagger.Provides

import io.github.tobyhs.remotescreenlocker.android.db.AppDatabase
import io.github.tobyhs.remotescreenlocker.android.db.ComputerDao

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

    /**
     * @return Room database for the app
     */
    @Provides
    @Singleton
    fun provideAppDatabase(): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "app.db").build()
    }

    /**
     * @param appDatabase Room database for the app
     * @return DAO for the computers table
     */
    @Provides
    @Singleton
    fun provideComputerDao(appDatabase: AppDatabase): ComputerDao = appDatabase.computerDao()
}
