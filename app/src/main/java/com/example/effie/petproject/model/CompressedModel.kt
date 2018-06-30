package com.example.effie.petproject.model

import com.google.gson.annotations.SerializedName

data class RootResponse(
        @SerializedName("@encoding") val encoding: String,
        @SerializedName("@version") val version: String,
        val petfinder: Petfinder
)

data class Petfinder(
        val xmlnsXsi: String,
        val lastOffset: GenericString,
        val pets: Pets
        // val header: Header,
        //     val xsiNoNamespaceSchemaLocation: String
)

data class Header(
        val timestamp: GenericString,
        val status: Status,
        val version: GenericString
)

data class Status(
        val message: Message,
        val code: GenericString
)

data class GenericString(
        @SerializedName("\$t") val t: String
)

class Message()

data class Pets(
        val pet: List<Pet>
)

data class Pet(
        //val status: GenericString,
        //val contact: Contact,
        val age: GenericString,
        val size: GenericString,
        val media: Media,
        val id: GenericString,
        //val shelterPetID: GenericString,
        //  val breeds: Breeds,
        val name: GenericString,
        val sex: GenericString,
        val description: GenericString,
        //val mix: GenericString,
        //val shelterID: GenericString,
        //val lastUpdate: GenericString,
        val animal: GenericString
)

data class Breeds(
        val breed: List<GenericString>
)

data class Breed(val value: List<GenericString>)

data class Contact(
        val phone: GenericString,
        val state: GenericString,
        val address2: Message,
        val email: GenericString,
        val city: GenericString,
        val zip: GenericString,
        val fax: Message,
        val address1: GenericString
)

data class Media(
        val photos: Photos? = null
)

data class Photos(
        val photo: List<Photo>
)

data class Photo(
        val size: Size,
        val t: String,
        val id: String
)

enum class Size {
    Fpm,
    Pn,
    Pnt,
    T,
    X
}
