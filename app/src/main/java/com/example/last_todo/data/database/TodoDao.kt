package com.example.last_todo.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.last_todo.data.model.Todo

@Dao
interface TodoDao {
    @Query("Select * from TODO")
    fun getAllData(): LiveData<List<Todo>>

    @Insert
    fun addTodo(todo : Todo)

    @Query("delete from todo where id = :id")
    fun deleteTodo(id: Int)

    @Query("UPDATE todo SET `desc` = :newDescription WHERE id = :id")
    fun updateTodo(id: Int, newDescription: String)
}