package com.example.gmailclone.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerMenuData (
    val icon: ImageVector? = null,
    val title: String? = null,
    val isDivider: Boolean = false,
    val isHeader: Boolean = false
) {
    object AllInboxes: DrawerMenuData(icon = Icons.Outlined.AllInbox, title = "All Inboxes")
    object Primary: DrawerMenuData(icon = Icons.Outlined.Inbox, title = "Primary")
    object Social: DrawerMenuData(icon = Icons.Outlined.Person, title = "Social")
    object Starred: DrawerMenuData(icon = Icons.Outlined.StarOutline, title = "Starred")
    object Snoozed: DrawerMenuData(icon = Icons.Outlined.Snooze, title = "Snoozed")
    object Important: DrawerMenuData(icon = Icons.Outlined.Label, title = "Important")
    object Sent: DrawerMenuData(icon = Icons.Outlined.Send, title = "Sent")
    object Scheduled: DrawerMenuData(icon = Icons.Outlined.Schedule, title = "Scheduled")
    object Calendar: DrawerMenuData(icon = Icons.Outlined.CalendarToday, title = "Calendar")
    object Contacts: DrawerMenuData(icon = Icons.Outlined.Contacts, title = "Contacts")
    object Settings: DrawerMenuData(icon = Icons.Outlined.Settings, title = "Settings")

    // Dividers
    object Divider: DrawerMenuData(isHeader = true)
    object HeaderOne: DrawerMenuData(isHeader = true, title = "ALL LABELS")
    object HeaderTwo: DrawerMenuData(isHeader = true, title = "GOOGLE APPS")
}