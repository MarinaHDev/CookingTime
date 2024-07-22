package com.example.cookingtime

import android.util.Log
import com.example.cookingtime.contracts.CookingTimeListenerContract
import com.example.cookingtime.contracts.CookingTimePresenterContract
import com.example.cookingtime.contracts.CookingTimeRepositoryContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class CookingTimePresenter(private val repo: CookingTimeRepositoryContract) :
    CookingTimePresenterContract {

    internal var listener: CookingTimeListenerContract? = null
    private val courutineScope = CoroutineScope(Dispatchers.Main)

    override fun fetchSummaryRecipes() {
        Log.e("Marina","Fetching recipes")
        courutineScope.launch {
            try {
                val allRecipiesFetched = repo.fetchRecipes()
                listener?.updateStates(
                    CookingTimeMainViewStates.FetchedRecipesState(
                        allRecipiesFetched
                    )
                )
            } catch (e: Exception) {
                listener?.updateStates(CookingTimeMainViewStates.RecipesErrorState("Something went wrong"))
                courutineScope.cancel()
            }
        }


    }

    override fun setListener(recipelistener: CookingTimeListenerContract) {
        Log.e("Marina", "Settin the listner ")
        listener = recipelistener
        Log.e("MArina", "Listener setted")
    }

    override fun disposeListener() {
        listener = null
    }

}