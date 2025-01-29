package com.example.last_todo.ui.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.last_todo.data.model.Todo
import com.example.last_todo.ui.main.MainApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel : ViewModel() {
    val todoDao = MainApplication.todoDatabase.getTodoDao()
    val todoList = todoDao.getAllData()

    fun addTodo(desc: String) {
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.addTodo(
                Todo(
                    desc = desc,
                    createdAt = Date.from(Instant.now())
                )
            )
        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.deleteTodo(id)
        }
    }

    fun updateTodo(id: Int, newDescription: String) {
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.updateTodo(id, newDescription)
        }
    }
}