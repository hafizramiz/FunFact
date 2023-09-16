package com.hafizramiz.funfacts.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.funfact.R
import com.example.funfact.ui.ButtonComponent
import com.example.funfact.ui.PersonCard
import com.example.funfact.ui.TexFieldComponent
import com.example.funfact.ui.TextComponent
import com.example.funfact.ui.TopBar
import com.example.funfact.ui.UserInputViewModel
import com.example.funfact.ui.data.UserDataUiEvents

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInputScreen(
    myViewModel: UserInputViewModel,
    showNextScreen:(Pair<String, String>)->Unit
//    navController: NavController
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar("Hi Kotlin Developer")
            TextComponent(textValue = "Lets Learn about you", textSize = 24.sp)
            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "This app will prepare a details page based on input provided you",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))
            TextComponent(textValue = stringResource(id = R.string.name), textSize = 18.sp)
            Spacer(modifier = Modifier.size(10.dp))

            TexFieldComponent(onValueChanged = {
                myViewModel.onEvent(UserDataUiEvents.UserNameEntered(userInputName = it))
            })
            Spacer(modifier = Modifier.size(20.dp))
            TextComponent(
                textValue = stringResource(id = R.string.what_you_like), textSize = 15.sp
            )

            Row(modifier = Modifier.fillMaxWidth()) {
                PersonCard(
                    imageResource = R.drawable.men,
                    personSelectedFunc =
                    { myViewModel.onEvent(UserDataUiEvents.PersonSelected(it)) })

                PersonCard(imageResource = R.drawable.women, personSelectedFunc = {
                    myViewModel.onEvent(UserDataUiEvents.PersonSelected(it))
                })
            }
            Spacer(modifier = Modifier.weight(1f))
            if (myViewModel.isValidate()) {
                ButtonComponent(goToDetailsScreen = {
                    println("go do details tiklandi")
                    //navController.navigate(route = Routes.WELCOME_SCREEN)
                    var name=myViewModel.uiState.value.nameEntered
                    var animalSelected=myViewModel.uiState.value.personSelected
                    showNextScreen(Pair(name,animalSelected))
                })
            }
        }
    }
}


@Preview
@Composable
fun UserInputScreenPreview() {
    // UserInputScreen( )
}


