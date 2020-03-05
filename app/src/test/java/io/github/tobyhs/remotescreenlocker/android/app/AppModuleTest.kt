package io.github.tobyhs.remotescreenlocker.android.app

import androidx.test.core.app.ApplicationProvider

import com.github.tobyhs.rxsecretary.android.AndroidSchedulerProvider

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
}
