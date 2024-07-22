package com.example.cookingtime.contracts

import com.example.cookingtime.models.RecipeModel

interface CookingTimeRepositoryContract {
    suspend fun fetchRecipes(): List<RecipeModel>
}