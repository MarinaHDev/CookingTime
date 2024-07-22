package com.example.cookingtime

import com.example.cookingtime.models.RecipeModel

sealed class CookingTimeMainViewStates {
    data object InitActivityState: CookingTimeMainViewStates()
    data object LoadingState: CookingTimeMainViewStates()
    data class FetchedRecipesState(val retrievedRecipes: List<RecipeModel>): CookingTimeMainViewStates()
    data class  RecipesErrorState(val  errorMessage: String): CookingTimeMainViewStates()
}