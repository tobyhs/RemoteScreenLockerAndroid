package io.github.tobyhs.remotescreenlocker.android.rslapi

import io.reactivex.Single

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.Url

/**
 * Retrofit interface for the remote screen locker API
 */
interface ScreenService {
    /**
     * Get information about the screen of a computer
     *
     * @param url API URL to get information about the screen of a computer
     * @param token remote screen locker API token
     * @return information about the screen of a computer
     */
    @GET
    fun getScreen(@Url url: String, @Header("X-Token") token: String): Single<Screen>

    /**
     * Update the screen of a computer
     *
     * @param url API URL to update the screen of a computer
     * @param token remote screen locker API token
     * @param screen object with details to update
     * @return updated information about the screen of a computer
     */
    @PATCH
    fun updateScreen(
        @Url url: String,
        @Header("X-Token") token: String,
        @Body screen: Screen
    ): Single<Screen>
}
