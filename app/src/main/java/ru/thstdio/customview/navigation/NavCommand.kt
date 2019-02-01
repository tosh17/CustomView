package ru.thstdio.customview.navigation

import androidx.navigation.NavController

class NavCommand {
    private lateinit var navController: NavController
    fun init(navController: NavController) {
        this.navController = navController
    }

}