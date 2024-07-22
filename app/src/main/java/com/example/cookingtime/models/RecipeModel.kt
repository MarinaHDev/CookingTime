package com.example.cookingtime.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true )
data class RecipeModel (
    val id: Int,
    val title: String,
    val ingredients: List<String>,
    val instructions: String,
    @Json(name = "cooking_time" )
    val cookingTime: String,
    @Json(name = "number_of_portions" )
    val numberOfPortions: Int,
    @Json(name = "nutrimental_information" )
    val nutritionInformation: RecipeNutrimentalInformationModel,
    @Json(name = "dish_photo" )
    val dishPhoto: String

)