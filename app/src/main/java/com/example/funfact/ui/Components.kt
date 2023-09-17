package com.example.funfact.ui

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.ImeOptions
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfact.R
import com.example.funfact.ui.data.UserDataUiEvents

@Composable
fun TopBar(topBarText: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = topBarText, color = Black, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.kotlinlogo),
            contentDescription = "Kotlin Logo"
        )
    }

}

@Composable
fun TextComponent(textValue: String, textSize: TextUnit, color: Color = Black) {
    Text(text = textValue, fontSize = textSize, color = color, fontWeight = FontWeight.Light)
}

@Preview(showBackground = true)
@Composable
fun TextComponentpreView() {
    TextComponent("A", 23.sp)
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar("Hi Kotlin Developer")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TexFieldComponent(
    // bu bir callback fonksiyonudur.
    // Buna burda verdigim parameterye Compose'u cagirdigim yerde elde edebilecegim.
    // Onemli nokta callback fonksiyonunun parametre almasi gerekiyor.Aksi takdirde
    // hata aliyorim. Yani soyle olursa hata alcam: onValueChanged:()->Unit
    onValueChanged: (userInputName: String) -> Unit
) {
    var currentValue by remember { mutableStateOf(" ") }
    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue, onValueChange = {
            currentValue = it
            onValueChanged(it)
        },
        placeholder = {
            Text(stringResource(id = R.string.enter_your_name), fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions {
            localFocusManager
        }
    )
}

@Composable
fun PersonCard(
    imageResource: Int,
//    selected: Boolean,
    personSelectedFunc: (personName: String) -> Unit
) {
    var localFocusManager = LocalFocusManager.current
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .clickable {
                        localFocusManager.clearFocus()
                        val personName = if (imageResource == R.drawable.women) {
                            "Women"
                        } else {
                            "Men"
                        }
                        personSelectedFunc(personName)
                    },
                painter = painterResource(id = imageResource),
                contentDescription = "men picture",
            )
        }

    }
}

@Composable
fun ResultCard(value: String) {
    Card(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(18.dp, 24.dp)) {
            Text(text = "dd")
            Image(painter = painterResource(id = R.drawable.men),
                contentDescription = "Qouto")
            Spacer(modifier = Modifier.size(60.dp))

        }

    }
}


@Composable
fun ButtonComponent(
    goToDetailsScreen: () -> Unit
) {
    Button(modifier = Modifier.fillMaxWidth(),
        onClick = { goToDetailsScreen() }) {
        TextComponent(
            textValue = stringResource(id = R.string.go_to_details_screen),
            textSize = 18.sp,
            color = Color.White
        )
    }

}


@Preview(showBackground = true)
@Composable
fun TexFieldComponentPreview() {
    TexFieldComponent({})
}

