package com.example.kotlintestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintestapp.ui.theme.KotlinTestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinTestAppTheme {
                MyComposeScreen()
            }
        }
        inicio()
    }
}

@Composable
fun MyComposeScreen() {
    var input1 by remember { mutableStateOf(TextFieldValue("")) }
    var input2 by remember { mutableStateOf(TextFieldValue("")) }
    var input3 by remember { mutableStateOf(TextFieldValue("")) }
    var input4 by remember { mutableStateOf(TextFieldValue("")) }
    var input5 by remember { mutableStateOf(TextFieldValue("")) }
    var output by remember { mutableStateOf(TextFieldValue("")) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        // Entrada 1 a Entrada 5

        Text(text = "Entrada 1:")
        OutlinedTextField(
            value = input1,
            onValueChange = { input1 = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Entrada 2:")
        OutlinedTextField(
            value = input2,
            onValueChange = { input2 = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Entrada 3:")
        OutlinedTextField(
            value = input3,
            onValueChange = { input3 = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Entrada 4:")
        OutlinedTextField(
            value = input4,
            onValueChange = { input4 = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Entrada 5:")
        OutlinedTextField(
            value = input5,
            onValueChange = { input5 = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Salidas
        Text(text = "Salidas:")
        OutlinedTextField(
            value = output,
            onValueChange = { output = it },
            singleLine = false,
            enabled = false,
            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),  // Texto negro y tamaño 16sp
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(8.dp)
                .verticalScroll(scrollState)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Botones de acción
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                val text: String? = boton1Pulsado(input1.text, input2.text, input3.text, input4.text, input5.text)
                if (text != null) output = TextFieldValue(text + "\n" + output.text)
            })
            {
                Text(text = "Acción 1")
            }
            Button(onClick = {
                val text: String? = boton2Pulsado(input1.text, input2.text, input3.text, input4.text, input5.text)
                if (text != null) output = TextFieldValue(text + "\n" + output.text)
            })
            {
                Text(text = "Acción 2")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                val text: String? = boton3Pulsado(input1.text, input2.text, input3.text, input4.text, input5.text)
                if (text != null) output = TextFieldValue(text + "\n" + output.text)
            })
            {
                Text(text = "Acción 3")
            }
            Button(onClick = {
                val text: String? = boton4Pulsado(input1.text, input2.text, input3.text, input4.text, input5.text)
                if (text != null) output = TextFieldValue(text + "\n" + output.text)
            })
            {
                Text(text = "Acción 4")
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                val text: String? = boton5Pulsado(input1.text, input2.text, input3.text, input4.text, input5.text)
                if (text != null) output = TextFieldValue(text + "\n" + output.text)
            })
            {
                Text(text = "Acción 5")
            }
            Button(onClick = {
                val text: String? = boton6Pulsado(input1.text, input2.text, input3.text, input4.text, input5.text)
                if (text != null) output = TextFieldValue(text + "\n" + output.text)
            })
            {
                Text(text = "Acción 6")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KotlinTestAppTheme {
        MyComposeScreen()
    }
}

// ---------------------------------------------------------------------------------------------------------
// Programa aquí tu código
// La función inicio es llamada por el evento onCreate de la Activity
// Añade en cada una de las demás funciones el código a ejecutar cuando se pinche el botón correspondiente
// Cada manejador de botón recibe las entradas de las 5 cajas de texto, y lo que devuelvan se añadirá a la caja de texto de salidas
// ---------------------------------------------------------------------------------------------------------

fun inicio() {
    
}

fun boton1Pulsado(input1: String, input2: String, input3: String, input4: String, input5: String): String?
{
    val g = Gerente(500.0)
    val d = Desarrollador("Kotlin")
    return "${g.mostrarDetalles()}\n${d.mostrarDetalles()}";
}

fun boton2Pulsado(input1: String, input2: String, input3: String, input4: String, input5: String): String?
{
    //return "Acción 2 ejecutada con ${input1}, ${input2}, ${input3}, ${input4}, ${input5}"
    return null;
}

fun boton3Pulsado(input1: String, input2: String, input3: String, input4: String, input5: String): String?
{
    //return "Acción 3 ejecutada con ${input1}, ${input2}, ${input3}, ${input4}, ${input5}"
    return null;
}

fun boton4Pulsado(input1: String, input2: String, input3: String, input4: String, input5: String): String?
{
    //return "Acción 4 ejecutada con ${input1}, ${input2}, ${input3}, ${input4}, ${input5}"
    return null;
}

fun boton5Pulsado(input1: String, input2: String, input3: String, input4: String, input5: String): String?
{
    //return "Acción 5 ejecutada con ${input1}, ${input2}, ${input3}, ${input4}, ${input5}"
    return null;
}

fun boton6Pulsado(input1: String, input2: String, input3: String, input4: String, input5: String): String?
{
    //return "Acción 6 ejecutada con ${input1}, ${input2}, ${input3}, ${input4}, ${input5}"
    return null;
}
