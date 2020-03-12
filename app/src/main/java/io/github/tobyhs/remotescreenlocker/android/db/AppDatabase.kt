package io.github.tobyhs.remotescreenlocker.android.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Room database for the app
 */
@Database(version = 1, entities = [Computer::class])
abstract class AppDatabase : RoomDatabase() {
    /**
     * @return DAO for the computers table
     */
    abstract fun computerDao(): ComputerDao
}
