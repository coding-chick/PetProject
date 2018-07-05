package com.example.effie.petproject.ViewModel

import com.example.effie.petproject.model.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PetViewModelTest {
    val media = Media(Photos(listOf(SinglePhoto(Size.fpm, "fpm", "1"),
            SinglePhoto(Size.x, "x1", "2"),
            SinglePhoto(Size.x, "x2", "3")
    )))

    val petModel = Pet(GenericString("5"), GenericString("small"), media, GenericString("1"),
            GenericString("name"), GenericString("sex"), GenericString("description"),
            GenericString("animal"))

    @Test
    fun testUrlReturnFirstXSizeInPhotosPetViewModel() {
        val petViewModel = PetViewModel(petModel)
        val urlX = petViewModel.imageUrl()
        Assert.assertTrue(urlX == "x1")
    }
}