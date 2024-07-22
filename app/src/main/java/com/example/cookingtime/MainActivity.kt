package com.example.cookingtime

import android.os.Binder
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cookingtime.contracts.CookingTimeListenerContract
import com.example.cookingtime.databinding.ActivityMainBinding
import com.example.cookingtime.models.RecipeModel
import java.lang.Error

class MainActivity : AppCompatActivity(), CookingTimeListenerContract {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: CookingTimePresenter
    //private lateinit var binder: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = (application as CookingTimeApp).presenter

    }

    override fun onStart() {
        super.onStart()
        presenter.setListener(this)
        presenter.fetchSummaryRecipes()

    }

    override fun onStop() {
        presenter.disposeListener()
        super.onStop()
    }

    override fun updateStates(state: CookingTimeMainViewStates) {
        when(state){
            is CookingTimeMainViewStates.FetchedRecipesState -> whenRetrivedRecipes(state.retrievedRecipes)
            CookingTimeMainViewStates.InitActivityState -> TODO()
            CookingTimeMainViewStates.LoadingState -> TODO()
            is CookingTimeMainViewStates.RecipesErrorState -> whenError(state.errorMessage)
        }
    }

    private fun whenRetrivedRecipes(recipies: List<RecipeModel>){
        Log.e("Hayali", "you have ${recipies.size} recipes")
    }

    private fun whenError(error: String){
        Log.e("Hayali", "You have this error: $error")
    }
}