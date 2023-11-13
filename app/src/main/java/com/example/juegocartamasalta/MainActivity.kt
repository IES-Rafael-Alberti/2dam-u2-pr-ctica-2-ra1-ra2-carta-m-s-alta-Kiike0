package com.example.juegocartamasalta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.juegocartamasalta.ui.theme.JuegoCartaMasAltaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JuegoCartaMasAltaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    accionIniciar()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun prevAccionInicio(){
    accionIniciar()
}
@Composable
fun accionIniciar(){
    val context = LocalContext.current
    var showCard by rememberSaveable { mutableStateOf("reverso") }
    val miBaraja = Baraja
    Column( modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = painterResource(id = context.resources.getIdentifier(showCard, "drawable", context.packageName) ),
            contentDescription = "Carta"
        )
        Row(
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                onClick = {
                    val choosenCard = miBaraja.dameCarta()
                    showCard = if (choosenCard == null) {
                        "reverso"
                    } else
                        "c" + choosenCard.idDrawable.toString()
                },
            ) {
                Text(text = "Dame una carta ")
            }
            Button(onClick = {
                miBaraja.crearBaraja()
                miBaraja.barajar()
                showCard = "reverso"
            }) {
                Text("Reiniciar ")
            }
        }
    }
}