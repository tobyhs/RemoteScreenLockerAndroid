package io.github.tobyhs.remotescreenlocker.android.app

import androidx.test.core.app.ApplicationProvider

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat

import org.junit.Test
import org.junit.runner.RunWith

import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = App::class)
class AppTest {
    private val app: App = ApplicationProvider.getApplicationContext()

    @Test
    fun applicationInjector() {
        assertThat(app.applicationInjector() is AppComponent, equalTo(true))
    }
}
