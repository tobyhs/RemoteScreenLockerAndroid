package io.github.tobyhs.remotescreenlocker.android.app

import androidx.test.core.app.ApplicationProvider

import com.github.tobyhs.rxsecretary.android.AndroidSchedulerProvider

import io.github.tobyhs.remotescreenlocker.android.db.AppDatabase
import io.github.tobyhs.remotescreenlocker.android.db.ComputerDao

import io.mockk.every
import io.mockk.mockk

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat

import org.junit.Test
import org.junit.runner.RunWith

import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = App::class)
class AppModuleTest {
    private val app: App = ApplicationProvider.getApplicationContext()
    private val module: AppModule = AppModule(app)

    @Test
    fun provideApp() {
        assertThat(module.provideApp(), `is`(app))
    }

    @Test
    fun provideSchedulerProvider() {
        assertThat(module.provideSchedulerProvider() is AndroidSchedulerProvider, equalTo(true))
    }

    @Test
    fun provideAppDatabase() {
        val appDatabase: AppDatabase = module.provideAppDatabase()
        assertThat(appDatabase.openHelper.databaseName, equalTo("app.db"))
    }

    @Test
    fun provideComputerDao() {
        val appDatabase: AppDatabase = mockk()
        val computerDao: ComputerDao = mockk()
        every { appDatabase.computerDao() } returns computerDao
        assertThat(module.provideComputerDao(appDatabase), equalTo(computerDao))
    }
}
