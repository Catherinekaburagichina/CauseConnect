package com.example.causeconnect

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.causeconnect.ui.theme.DonatePage
import com.example.causeconnect.ui.theme.HomePage
import com.example.causeconnect.ui.theme.NavItem
import com.example.causeconnect.ui.theme.ProfilePage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier=Modifier) {
    val NavItemList = listOf(
        NavItem("Home",Icons.Default.Home),
        NavItem("Donate",Icons.Default.Favorite),
        NavItem("Profile",Icons.Default.Person)
    )
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
    }

    Scaffold (modifier = Modifier.fillMaxSize(), containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {{ /*TODO*/ }},
                modifier = Modifier.height(55.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF00356B),
                )
            ) },
        bottomBar = { NavigationBar {NavItemList.forEachIndexed { index, navItem ->
             NavigationBarItem(selected = selectedIndex == index, onClick = {selectedIndex = index}, icon = { Icon(
                 imageVector = navItem.icon,
                 contentDescription = "icon",
             )}, label = { Text(text = navItem.label)})
    }}}) 
    
    { innerPadding -> ContentScreen(modifier = Modifier.padding(innerPadding),selectedIndex) }

}

@Composable
fun ContentScreen(modifier: Modifier = Modifier,selectedIndex:Int) {
    when(selectedIndex){
        0-> HomePage()
        1-> DonatePage()
        2 -> ProfilePage()
    }
}