package com.bassel.mvvmnewsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bassel.mvvmnewsapp.models.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    /**  Handled By Room Database */
    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile
        // Static Instance
        private var instance: ArticleDatabase? = null

        // used to lock the threads
        private val LOCK = Any()

        /** called when i create object from class
         * return the instance of these class
         * if [instance] == [null] start thread synchronized  of [LOCK] object
         * to make sure that any thread will not modify the variable before the thread is done
         * return [instance] if not [null]
         * else call  [createDatabase] to create a new instance from this class for one time
         * and return instance
         */
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }
        /**
         * create instance from this class and a database for one time
         */
        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ArticleDatabase::class.java,
            "article_db.db"
        ).build()
    }
}