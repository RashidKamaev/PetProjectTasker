//package com.example.tasker11
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.background
//import androidx.compose.foundation.horizontalScroll
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Badge
//import androidx.compose.material3.BadgedBox
//import androidx.compose.material3.Icon
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.modifier.ModifierLocalReadScope
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.tasker11.ui.theme.Tasker11Theme
//
//data class BottomNavigationItem(
//    val title: String,
//    val selecttedIcon: ImageVector,
//    val unselectedIcon: ImageVector,
//    val hasNews: Boolean,
//    val badgeCount: Int? = null
//
//)
//
//class MainActivity : ComponentActivity() {
//    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            val items = listOf(
//                BottomNavigationItem (
//                    title = "Home"
//                    selectedIcon = Icons.Filled.Home,
//                    unselectedIcon = Icons.Outlined.Home,
//                    hasNews = false,),
//                BottomNavigationItem (
//                    title = "Settings"
//                            selectedIcon = Icons.Filled.Settings,
//                    unselectedIcon = Icons.Outlined.Settings,
//                    hasNews = false,
//                ),
//                BottomNavigationItem (
//                    title = "Home"
//                            selectedIcon = Icons.Filled.Home,
//                    unselectedIcon = Icons.Outlined.Home,
//                    hasNews = false,
//                ),
//            )
//            Row(
//                modifier = Modifier
//                    .background(Color.Blue)
//                    .fillMaxWidth()
//                    .fillMaxHeight(0.05f),
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(text = "Tasker")
//            }
//            var selecttedItemIndex by rememberSaveable {
//                mutableStateOf(0)
//            }
//            Scaffold {
//                var bottomBar = @Composable {
//                    NavigationBar() {
//                        items.forEachIndexed { index, item -> }
//                        NavigationBarItem(
//                            selected = selecttedItemIndex == index,
//                            onClick = {
//                                selecttedItemIndex = index
//                                // navController.navigate(item.title)
//                            },
//                            label = {
//                                Text(text = item.title)
//                            },
//                            alwaysShowLabel = false,
//                            icon = {
//                                BadgedBox(
//                                    badge = {
//                                        if (item.BadgeCount != null) {
//                                            Badge {
//                                                Text(text = item.badgeCount.toString())
//                                            }
//                                        } else if (item.hasNews) {
//                                            Badge()
//                                        }
//                                    }
//                                ) {
//                                    Icon(
//                                        imageVector = if (index == selecttedItemIndex) {
//                                            item.selectedIcon
//                                        } else item.unselectedIcon,
//                                        contentDescription = item.title
//                                    )
//                                }
//                            })
//                    }
//                }
//            }
//        }
//    }
//}

package com.example.tasker11

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val items = listOf(
                BottomNavigationItem(
                    title = "Профиль",
                    selectedIcon = Icons.Filled.Person,
                    unselectedIcon = Icons.Outlined.Person,
                    hasNews = false
                ),
                BottomNavigationItem(
                    title = "Мои темы",
                    selectedIcon = Icons.Filled.Home,
                    unselectedIcon = Icons.Outlined.Home,
                    hasNews = false
                ),
                BottomNavigationItem(
                    title = "Новая тема",
                    selectedIcon = Icons.Filled.AddCircle,
                    unselectedIcon = Icons.Outlined.AddCircle,
                    hasNews = false,

                ),
            )

            var selectedItemIndex by rememberSaveable {
                mutableStateOf(0)
            }

            Scaffold(
                bottomBar = {
                    NavigationBar {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedItemIndex == index,
                                onClick = {
                                    selectedItemIndex = index
                                    // navController.navigate(item.title)
                                },
                                label = {
                                    Text(text = item.title)
                                },
                                alwaysShowLabel = true,
                                icon = {
                                    BadgedBox(
                                        badge = {
                                            if (item.badgeCount != null) {
                                                Badge {
                                                    Text(text = item.badgeCount.toString())
                                                }
                                            } else if (item.hasNews) {
                                                Badge()
                                            }
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if (index == selectedItemIndex) {
                                                item.selectedIcon
                                            } else item.unselectedIcon,
                                            contentDescription = item.title
                                        )
                                    }
                                }
                            )
                        }
                    }
                }
            ) {
                Row(
                    modifier = Modifier
                        .background(Color.Green)
                        .fillMaxWidth()
                        .fillMaxHeight(0.05f),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Tasker")
                }
            }
        }
    }
}
