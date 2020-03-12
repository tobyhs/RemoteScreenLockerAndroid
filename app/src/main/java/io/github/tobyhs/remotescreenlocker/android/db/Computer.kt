package io.github.tobyhs.remotescreenlocker.android.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * A computer to make remote screen locker API calls on
 *
 * @property id ID
 * @property name user-given name for the computer
 * @property baseUrl URL prefix of remote screen locker API
 * @property token remote screen locker API token
 */
@Entity(tableName = "computers", indices = [Index(value = ["name"], unique = true)])
data class Computer(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    @ColumnInfo(name = "base_url") val baseUrl: String,
    val token: String
)
