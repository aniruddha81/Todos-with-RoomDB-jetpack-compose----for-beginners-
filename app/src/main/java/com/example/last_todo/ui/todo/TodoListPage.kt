package com.example.last_todo.ui.todo

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.last_todo.data.model.Todo
import java.text.SimpleDateFormat

@Composable
fun TodoListPage(viewModel: TodoViewModel) {
    var inputText by remember { mutableStateOf("") }
    val todoList by viewModel.todoList.observeAsState(emptyList())
    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                label = { Text(text = "Add a Todo") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
            Button(
                onClick = {
                    if (inputText.isNotEmpty()) {
                        viewModel.addTodo(inputText)
                        inputText = ""
                    } else {
                        Toast.makeText(context, "Please write something", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .height(56.dp)
                    .padding(start = 4.dp)
            ) {
                Text(text = "Add")
            }
        }

        if (todoList.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "No Items Yet",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                )
            }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(todoList) { item ->
                    TodoItem(
                        item = item,
                        onDelete = { viewModel.deleteTodo(item.id) },
                        onUpdate = { newDesc -> viewModel.updateTodo(item.id, newDesc) }
                    )
                }
            }
        }
    }
}

@Composable
fun TodoItem(item: Todo, onDelete: () -> Unit, onUpdate: (String) -> Unit) {
    var isEditing by remember { mutableStateOf(false) }
    var updateDesc by remember { mutableStateOf(item.desc) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if (isEditing) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.primaryContainer,
            contentColor = if (isEditing) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onPrimaryContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        if (isEditing) {
            Column(Modifier.padding(16.dp)) {
                OutlinedTextField(
                    value = updateDesc,
                    onValueChange = { updateDesc = it },
                    label = { Text(text = "Edit Todo") },
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = {
                        isEditing = false
                        updateDesc = item.desc
                    }) {
                        Text(text = "Cancel")
                    }
                    Button(
                        onClick = {
                            onUpdate(updateDesc)
                            isEditing = false
                        },
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Text(text = "Save")
                    }
                }
            }
        } else {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(Modifier.weight(1f)) {
                    Text(
                        text = SimpleDateFormat("HH:mm aa, dd/MM", java.util.Locale.ENGLISH).format(item.createdAt),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                    )
                    Text(
                        text = item.desc,
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        fontSize = 18.sp
                    )
                }
                IconButton(onClick = { isEditing = true }) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                IconButton(onClick = onDelete) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}
