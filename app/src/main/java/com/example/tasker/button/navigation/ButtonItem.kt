package com.example.tasker.button.navigation

import android.icu.text.CaseMap.Title
import com.example.tasker.R

sealed class ButtonItem {
    val title: String
    val iconId: Int
    val route: String

    constructor(title: String, iconId: Int, route: String) {
        this.title = title
        this.iconId = iconId
        this.route = route
    }

    object Screen1: BottomItem("Screen1", R.drawable.baseline_person_24)
}