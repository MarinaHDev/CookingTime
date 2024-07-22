package com.example.cookingtime.contracts

interface CookingTimePresenterContract {
    fun fetchSummaryRecipes()
    fun setListener(recipelistener: CookingTimeListenerContract)
    fun disposeListener()
}