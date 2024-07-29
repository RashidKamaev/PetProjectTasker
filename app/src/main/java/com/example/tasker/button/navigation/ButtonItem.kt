package com.example.tasker.button.navigation

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

    object Screen1: BottomItem("Screen1", R.drawable.baseline_person_24, "screen_1")
    object Screen2: BottomItem("Screen2", R.drawable.baseline_add_circle_outline_24, "screen_2")
    object Screen3: BottomItem("Screen3", R.drawable.baseline_archive_24, "screen_3")


    open class BottomItem(s: String, baselinePerson24: Int, s1: String) {

    }
}