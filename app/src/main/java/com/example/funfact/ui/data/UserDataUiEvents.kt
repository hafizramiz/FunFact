package com.example.funfact.ui.data
sealed class UserDataUiEvents(){
    // Bir onceki projede eventleri ben method ile yapmistim. Artik burda class ile yapiyorum.
    // Tipki Bloc da oldugu gibi. Event olarak classi ekrandan cagircam ve parametreyi vercem.
    // Burda  UserDataUiEvents sinifindan inherit aldim. Sebebi var. Cunku view model icinde bir fonksiyon yazcam
    // ona parametre olarak event vercem. Bu event ust sinifin tipndeki event olacak. Sonra event'e bakip ona gore logic kurcam
    // Ornek gosteriyorum:
//    fun onEvent(events: UserDataUiEvents){
//  burda logic kurcam event bu ise sunu yap. yoksa sunu yap diye
//    }
    // Burdaki name parametresi event'i view model gonderirken
    // bizden bir parametre istedigi icin bu parametreyi ekledik
    data class UserNameEntered(val userInputName:String):UserDataUiEvents()
    // animalValue da ayni sekilde event'i view modele gonderdigim zaman parametreli
    // event gondermem icindir.
    data class AnimalSelected(val animaInputValue:String):UserDataUiEvents()
}
