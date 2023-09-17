package com.hafizramiz.funfacts.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfact.R
import com.example.funfact.ui.TextComponent
import com.example.funfact.ui.TopBar
import com.example.funfact.ui.UserInputViewModel

@Composable
fun WelcomeScreen(myViewModel: UserInputViewModel) {
    println("selected: ${myViewModel.uiState.value.personSelected}")
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar(
                topBarText = stringResource(R.string.welcome) +
                        " " + "${myViewModel.uiState.value.nameEntered}"
            )
            TextComponent(textValue = stringResource(id = R.string.thank_you), textSize = 24.sp)
            Spacer(modifier = Modifier.size(60.dp))
            Text(
                text = stringResource(id = if (myViewModel.uiState.value.personSelected=="Men"){
                    R.string.kotlin_developer_boy
                }else{
                    R.string.kotlin_developer_girl
                }),
                fontSize = 24.sp,
                fontWeight = FontWeight.Light,
                style = TextStyle(
                    shadow = Shadow(Color.Blue, Offset(x = 1f, y = 2f), blurRadius = 2f)
                )
            )

            Card(
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp, 24.dp)) {
                    Image(  modifier = Modifier.size(40.dp),
                        painter = painterResource(id = R.drawable.quote_first),
                        contentDescription = "Qouto")
                    //Spacer(modifier = Modifier.size(60.dp))
                    Text(
                        text = stringResource(id = if (myViewModel.uiState.value.personSelected=="Men"){
                            R.string.boy_result
                        }else{
                            R.string.girl_result
                        }),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Light,
                        style = TextStyle(
                            shadow = Shadow(Color.Blue, Offset(x = 1f, y = 2f), blurRadius = 2f)
                        )
                    )
                    Image(  modifier = Modifier.size(40.dp),
                        painter = painterResource(id = R.drawable.quote_second),
                        contentDescription = "Qouto")
                }

            }

        }
    }
}


@Preview
@Composable
fun WelcomeScreenPreview() {
//    WelcomeScreen(myViewModel)
}