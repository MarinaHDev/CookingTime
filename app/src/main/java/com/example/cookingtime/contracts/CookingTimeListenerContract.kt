package com.example.cookingtime.contracts

import com.example.cookingtime.CookingTimeMainViewStates

interface CookingTimeListenerContract {
    fun updateStates(state: CookingTimeMainViewStates)
}