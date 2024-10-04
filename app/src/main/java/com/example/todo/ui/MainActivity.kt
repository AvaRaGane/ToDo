package com.example.todo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.model.Todo
import com.example.todo.ui.theme.ToDoTheme
import com.example.todo.ui.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoTheme {
                TodoScreen()
            }
        }
    }
}


@Composable
fun TodoScreen(todoViewModel: TodoViewModel = viewModel()){
    TodoList(todoViewModel.todos)
}

@Composable
fun TodoList(todos: List<Todo>){
    LazyColumn (
        modifier = Modifier.padding(40.dp)
    ) { items(todos) { todo->
        Text(
            text = todo.title,
            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
        )
        Divider(color = Color.LightGray, thickness = 1.dp)
    } }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToDoTheme {
        TodoScreen()
    }
}