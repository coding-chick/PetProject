package com.example.effie.petproject.ViewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.effie.petproject.model.RootResponse
import com.example.effie.petproject.network.PetApi
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


class MainActivityViewModel(petApi: PetApi.PetApiClient? = null) : ViewModel() {
    private val petApiClient: PetApi.PetApiClient = petApi ?: PetApi().getPetApiClient()
    val petsInSearch: MutableLiveData<List<PetViewModel>> = MutableLiveData()

    fun searchPets(): Observable<List<PetViewModel>> {
        if (petsInSearch.value != null) {
            return Observable.just(petsInSearch.value)
        }

        val ret = loadPets().cache()
        ret.toLiveData(petsInSearch, { e -> Log.e("foo", e.message) })

        return ret
    }

    private fun loadPets(): Observable<List<PetViewModel>> {
        return petApiClient.searchPet().subscribeOn(Schedulers.io()).map { t: RootResponse ->
            t.petfinder.pets.pet.map { it ->
                PetViewModel(it)
            }
        }
    }
}

