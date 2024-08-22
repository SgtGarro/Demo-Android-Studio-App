package com.example.semana2

import android.content.Intent
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.semana2.ui.theme.Semana2Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Semana2Theme {
                var txtUser by remember { mutableStateOf("") }
                var txtPassword by remember { mutableStateOf("") }
                var hasError by remember { mutableStateOf(false)}

                val txtUserTarget = "Jose Perez";
                val txtPasswordTarget = "UPC123";

                Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                    TopAppBar(
                        title = { Text(text = "Hello world") },
                        navigationIcon = {
                            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile")
                        }
                    )

                    Box(modifier = Modifier.padding(0.dp, 50.dp, 0.dp, 0.dp)) {
                        Image(painter = painterResource(id = R.drawable.rappi), contentDescription = null, modifier = Modifier
                            .height(200.dp))
                    }

                    Text(text = "Welcome to Rappi", fontSize = 32.sp, color = Color.Red)

                    OutlinedTextField(
                        value = txtUser,
                        onValueChange = {
                            txtUser = it
                        },
                        label={ Text(text = "Ingrese su usuario")},
                        modifier = Modifier.padding(top = 15.dp)
                    )

                    OutlinedTextField(
                        value = txtPassword,
                        onValueChange = {
                            txtPassword = it
                        },
                        label={ Text(text = "Ingrese su contraseña")},
                        modifier = Modifier.padding(top = 20.dp),
                        visualTransformation = PasswordVisualTransformation()
                    )

                    if (hasError) {
                        Text(text = "Usuario y/o password incorrecto")
                    }


                    Button(
                        onClick = {
                            if (txtUser == txtUserTarget && txtPassword == txtPasswordTarget) {
                                val navigate = Intent(this@MainActivity, MainActivity2::class.java)
                                navigate.putExtra("user", txtUser)
                                startActivity(navigate)
                                hasError = false
                            } else {
                                hasError = true
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color(255,78, 34)),
                        modifier = Modifier.padding(top=20.dp)
                    ) {
                        Text(text = "Ingresar", color = Color.White)
                    }

                }
            }


        }
    }
}
