package com.example.funfact.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.funfact.ui.data.UserDataUiEvents
import com.example.funfact.ui.data.UserInputScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserInputViewModel : ViewModel() {
    var uiState = mutableStateOf(UserInputScreenState())
//    private val _uiState1=MutableStateFlow(UserInputScreenState())
//    var uiState1: StateFlow<UserInputScreenState> = _uiState1.asStateFlow()
// TAG yazma islemi
    companion object{
    const val TAG="UserInputViewModel"
}

    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            // Burda event eger UserDataUiEvents sinifinin icindeki alt sinif olan ve data sinifi olan
            // UserNameEntered() sinifi ise yani event'i ise Birseyler yap. Yoksa baska birseyler yap
            is UserDataUiEvents.UserNameEntered -> {
                Log.d(TAG,"name entered eventi calisti")
                println("Name Entered event triggered.: ${event.userInputName}")
                //uiState.value= UserInputScreenState(nameEntered = "Name enetered event triggered")
                /// Event'ten gelen parametreyi almak icin event.parametreIsmi yazmamiz gerekiyor.
                // var olan state'i kopyaladim. Event'i arayuzde cagirirken event parametre istiyordu.
                // Ona orda parametre vermistim. O parametreyi burda elde etmek icin event.userInputName
                // yazarak aldim. Onu da var olan state'in koyasinda degisiklik yaptim.
                // State sinifininn bir degiskenini degistirdim
                uiState.value = uiState.value.copy(
                    nameEntered = event.userInputName
                )
            }

            is UserDataUiEvents.PersonSelected -> {
                println("Animla selected event triggered")
//                uiState.value =
//                    UserInputScreenState(animalSelected = "Animal selected event triggered")
                uiState.value=uiState.value.copy(personSelected = event.personInputValue)
                println("Secilen deger: ${event.personInputValue}")

            }
        }
    }
    fun isValidate():Boolean{
        if(!uiState.value.nameEntered.isNullOrEmpty()
            && !uiState.value.personSelected.isNullOrEmpty()){
            return true
        }else{
            return false
        }
    }
}


