package com.example.cookingtime.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true )
data class RecipeNutrimentalInformationModel(
    val calories:String,
    val protein:String,
    val carbohydrates:String,
    val fat: String
)