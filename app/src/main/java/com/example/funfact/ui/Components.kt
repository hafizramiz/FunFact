package com.example.funfact.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfact.R

@Composable
fun TopBar(topBarText: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = topBarText, color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.kotlinlogo),
            contentDescription = "Kotlin Logo"
        )
    }

}

@Composable
fun TextComponent(textValue: String, textSize: TextUnit, color: Color = Color.Black) {
    Text(text = textValue, fontSize = textSize, color = color, fontWeight = FontWeight.Light)
}

@Preview(showBackground = true)
@Composable
fun TextComponentpreView() {
    TextComponent("A",23.sp)
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar("Hi Kotlin Developer")
}

//@Composable
//fun  TexFieldComponent(){
//    OutlinedTextField(value = , onValueChange = )
//}

@Preview(showBackground = true)
@Composable
fun TexFieldComponentPreview(){
    // TexFieldComponent()
}

