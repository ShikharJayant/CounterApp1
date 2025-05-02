package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.counterapp.ui.theme.CounterAppTheme
import com.example.counterapp.ui.theme.CounterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: CounterViewModel = viewModel()
            CounterAppTheme {
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background)
               {
                   TheCounterApp(viewModel)
               }
            }
        }
    }
}

@Composable
fun TheCounterApp(viewModel: CounterViewModel){
//    val count = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Text(text = "Count: ${viewModel.count.value}",
            fontSize = 24.sp,
            fontWeight =  FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Row(){
            Button(onClick = {viewModel.increment()}) { Text("Increment")}
            Spacer(modifier = Modifier.width(22.dp))
            Button(onClick = {viewModel.decrement()}) { Text("Decrement")}
        }
    }
}
