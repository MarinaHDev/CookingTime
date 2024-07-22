package com.example.cookingtime

import android.app.Application
import com.example.cookingtime.contracts.CookingTimeRepositoryContract
import com.example.cookingtime.repositories.CookingTimeRepository

class CookingTimeApp: Application() {
    lateinit var cookingRepo: CookingTimeRepositoryContract
    lateinit var presenter: CookingTimePresenter

    override fun onCreate() {
        super.onCreate()
        val assetManager = applicationContext.assets
        cookingRepo = CookingTimeRepository(assetManager)
        presenter = CookingTimePresenter(cookingRepo)
    }
}