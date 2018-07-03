package com.example.effie.petproject.ViewModel

import com.example.effie.petproject.model.Pet
import com.example.effie.petproject.model.Size

class PetViewModel(val petModel: Pet) {
    fun imageUrl(): String? {
        val photoList = petModel.media.photos?.photoList ?: return null
        return photoList.first { photo -> photo.size == Size.x }.t
    }
}