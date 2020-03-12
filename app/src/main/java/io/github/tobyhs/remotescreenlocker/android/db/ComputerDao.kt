package io.github.tobyhs.remotescreenlocker.android.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * DAO for the computers table
 */
@Dao
interface ComputerDao {
    /**
     * Inserts a computer
     *
     * @param computer the computer to insert
     * @return the row ID of the computer that was inserted
     */
    @Insert
    fun insert(computer: Computer): Single<Long>

    /**
     * @return a [Flowable] that emits a list of all computers in name ascending order
     */
    @Query("SELECT * FROM computers ORDER BY name ASC")
    fun findAll(): Flowable<List<Computer>>

    /**
     * Updates a computer
     *
     * @param computer the computer to update
     * @return a [Completable] that completes when the computer is updated
     */
    @Update
    fun update(computer: Computer): Completable

    /**
     * Deletes a computer
     *
     * @param computer the computer to delete
     * @return a [Completable] that completes when the computer is deleted
     */
    @Delete
    fun delete(computer: Computer): Completable
}
