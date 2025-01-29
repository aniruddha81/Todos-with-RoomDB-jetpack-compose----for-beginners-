package com.example.last_todo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var desc : String,
    var createdAt : Date
)
