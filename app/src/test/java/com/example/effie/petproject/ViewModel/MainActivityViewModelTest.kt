package com.example.effie.petproject.ViewModel

import com.example.effie.petproject.model.*
import com.example.effie.petproject.network.PetApi
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Observable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainActivityViewModelTest {

    val testItems: List<Pet> = mutableListOf(
            Pet(GenericString(""), GenericString(""), Media(null), GenericString("1"),
                    GenericString("name1"), GenericString(""), GenericString(""), GenericString("")),
            Pet(GenericString(""), GenericString(""), Media(null), GenericString("2"),
                    GenericString("name2"), GenericString(""), GenericString(""), GenericString("")),
            Pet(GenericString(""), GenericString(""), Media(null), GenericString("3"),
                    GenericString("name3"), GenericString(""), GenericString(""), GenericString(""))
    )


    val rootResponse = RootResponse("encoding", "version", Petfinder("", GenericString(""),
            Pets(testItems)))

    val petApi: PetApi.PetApiClient = mock<PetApi.PetApiClient> {
        on { searchPet() } doReturn (Observable.just(rootResponse))
    }

    @Test
    fun testLoadSearchAnimals() {
        val mainActivityViewModel = MainActivityViewModel(petApi)
        mainActivityViewModel.searchPets().test().assertValueAt(0) { it.size == 3 }
    }
}