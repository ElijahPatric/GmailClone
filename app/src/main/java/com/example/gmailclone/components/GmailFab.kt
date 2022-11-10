package com.example.gmailclone.components

import androidx.compose.foundation.ScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun GmailFab(scrollState: ScrollState) {
    if(scrollState.value > 100) {
        // Extended Action Button
        ExtendedFloatingActionButton(
            text = { Text(text = "Compose", fontSize = 16.sp) },
            onClick = {},
            icon = { Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = ""
            )},
            backgroundColor = MaterialTheme.colors.surface
        )
    } else {
        // Floating Action Button
        FloatingActionButton(onClick = {},
            backgroundColor = MaterialTheme.colors.surface) {
            // Icon16
            Icon(imageVector = Icons.Default.Edit, contentDescription = "")
        }
    }
}