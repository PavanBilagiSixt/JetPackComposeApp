package com.example.basicsofcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class SimpleTextFieldButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleTextFieldButton()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextFieldButton() {
    var textFieldState by remember {
        mutableStateOf("")
    }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) }) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            TextField(
                value = textFieldState,
                label = {
                    Text(text = "Enter Your Name")
                },
                onValueChange = {
                    textFieldState = it
                },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        "Hello $textFieldState"
                    )
                }

            }) {
                Text(text = "Please Great Me")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleTextFieldButton()
}