package com.example.effie.petproject.network

import com.example.effie.petproject.model.RootResponse
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private var apiClient: PetApi.PetApiClient? = null

class PetApi {
    @Synchronized
    fun getPetApiClient(): PetApiClient {
        if (apiClient == null) {
            buildRetrofitInstance()
        }
        return apiClient!!
    }

    fun buildRetrofitInstance() {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.petfinder.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        apiClient = retrofit.create(PetApiClient::class.java)
    }

    interface PetApiClient {
        @GET("pet.find?key=5011e6dbd54925346f9b3a1d9e7817e6&format=json&animal=dog&location=94107")
        fun searchPet(): Observable<RootResponse>
    }
}