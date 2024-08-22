package com.example.semana2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.semana2.ui.theme.Semana2Theme

class MainActivity2 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Semana2Theme {
                val user = intent.getStringExtra("user")

                Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                    TopAppBar(
                        title = { Text(text = "Hello world, $user") },
                        navigationIcon = {
                            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile")
                        }
                    )

                    Box(modifier = Modifier.padding(0.dp, 50.dp, 0.dp, 0.dp)) {
                        Image(painter = painterResource(id = R.drawable.rappi), contentDescription = null, modifier = Modifier
                            .height(200.dp))
                    }

                    Text(text = "Welcome to Rappi", fontSize = 32.sp, color = Color.Red)
                    
                    Text(text = "Bienvenido a la aplicación, $user")
                }
            }
        }
    }
}
