package com.example.cookingtime.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true )
data class RecipeSummaryModel (
    val title: String,
    val cookingTime: String,
    val numberOfPortions: Int,
    val nutritionInformation: RecipeNutrimentalInformationModel
)