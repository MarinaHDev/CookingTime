package com.example.cookingtime.repositories

import android.content.res.AssetManager
import android.util.Log
import com.example.cookingtime.contracts.CookingTimeRepositoryContract
import com.example.cookingtime.models.RecipeModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CookingTimeRepository(private val assetManager: AssetManager):CookingTimeRepositoryContract {
    override suspend fun fetchRecipes(): List<RecipeModel> {
        return try {
            withContext(Dispatchers.IO){
                val inputStream = assetManager.open("Recipes.json")
                val json = inputStream.bufferedReader().use { it.readText() }
                Log.e("Marina", "Este es tu json $json")
                val moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
                val type = Types.newParameterizedType(List::class.java, RecipeModel::class.java)
                val adapter = moshi.adapter<List<RecipeModel>>(type)
                return@withContext adapter.fromJson(json) ?: emptyList()
            }
        } catch (e: Exception){
            emptyList<RecipeModel>()
        }
    }
}