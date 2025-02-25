package com.example.last_todo.ui.main

import android.app.Application
import androidx.room.Room
import com.example.last_todo.data.database.TodoDatabase

class MainApplication : Application() {
    companion object {
        lateinit var todoDatabase: TodoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        todoDatabase =
            Room.databaseBuilder(applicationContext, TodoDatabase::class.java, TodoDatabase.NAME)
                .build()
    }
}