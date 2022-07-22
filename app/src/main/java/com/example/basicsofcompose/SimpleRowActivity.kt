package com.example.basicsofcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicsofcompose.ui.theme.BasicsOfComposeTheme

class SimpleRowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleRowComponent()
        }
    }
}


@Composable
fun SimpleRowComponent() {
    //Row demo
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Hello")
        Text(text = "World")
        Text(text = "Hello")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultRowPreview() {
    SimpleRowComponent()
}
