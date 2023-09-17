package com.hafizramiz.funfacts.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.funfact.ui.UserInputViewModel

@Composable
fun FunFactsNavigationGraph(
    myViewModel: UserInputViewModel= viewModel()
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.USER_INPUT_SCREEN) {
        composable(Routes.USER_INPUT_SCREEN) {
            UserInputScreen(myViewModel=myViewModel, showNextScreen = {
                println(it.first)
                println(it.second)
                // Burda view modeldeki uiState'i degistirecegim.
                navController.navigate(Routes.WELCOME_SCREEN)
            })
        }
        composable(Routes.WELCOME_SCREEN) {
            WelcomeScreen(myViewModel=myViewModel)
        }
    };
}