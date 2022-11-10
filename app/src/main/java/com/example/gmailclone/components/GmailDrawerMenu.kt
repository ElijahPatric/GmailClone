package com.example.gmailclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailclone.model.DrawerMenuData

@Composable
fun GmailDrawerMenu(scrollState: ScrollState) {

    val menuList = listOf(
        DrawerMenuData.Divider,
        DrawerMenuData.AllInboxes,
        DrawerMenuData.Divider,
        DrawerMenuData.Primary,
        DrawerMenuData.Calendar,
        DrawerMenuData.Contacts,
        DrawerMenuData.HeaderOne,
        DrawerMenuData.Important,
        DrawerMenuData.Scheduled,
        DrawerMenuData.HeaderTwo,
        DrawerMenuData.Sent,
        DrawerMenuData.Settings,
        DrawerMenuData.Snoozed
    )
    // Column
    Column(Modifier.verticalScroll(scrollState)) {
        // Text
        Text(text = "Gmail",
            color = Color.Red,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
        // Menu List
        menuList.forEach {
            when {
                // Divider
                it.isDivider -> {
                    Divider(modifier = Modifier.padding(bottom = 20.dp, top = 20.dp))
                }
                // Header
                it.isHeader -> {
                    it.title?.let { it1 ->
                        Text(text = it1,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(start = 20.dp, bottom = 20.dp, top = 20.dp))
                    }
                } else -> {
                    MailDrawerItem(item = it)
                }
            }
        }
    }
}

@Composable
fun MailDrawerItem(item: DrawerMenuData) {
    // Row
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .padding(top = 16.dp)) {
        // Image
        Image(imageVector = item.icon!!, contentDescription = item.title!!, 
            modifier = Modifier.weight(0.5f))
        // Text
        Text(text = item.title,
            modifier = Modifier.weight(2.0f))

    }
}