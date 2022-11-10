package com.example.gmailclone.components


import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.gmailclone.R
import com.example.gmailclone.accountList
import com.example.gmailclone.model.Accounts

@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { openDialog.value = false },
        properties = DialogProperties(dismissOnClickOutside = false)
    ) {
        AccountsDialogUI(openDialog = openDialog)
    }
}

@Composable
fun AccountsDialogUI(modifier: Modifier = Modifier, openDialog: MutableState<Boolean>) {
    // Card
    Card() {
        // Column
        Column(modifier = Modifier
            .background(Color.White)
            .padding(bottom = 16.dp)) {
            // Row - Android
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                // Icon Button
                IconButton(onClick = { openDialog.value = false }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "close")
                }
                // Android Image
                Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .weight(2.0f)
                )

            }//: End Android Row
            // Row - Profile
            AccountItem(account = accountList[0])
            // Row - Google Account
            Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                // Card
                Card(modifier.requiredWidth(150.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, Color.Gray)
                ) {
                    // Text
                    Text(text = "Google Account",
                        modifier.padding(8.dp),
                        textAlign = TextAlign.Center
                    )
                }//: End Card
                // Spacer
                Spacer(modifier.width(10.dp))
            }//: End Row
            // Divider - Top
            Divider(modifier.padding(top = 16.dp))
            // Column - Other Accounts
            Column() {
                AccountItem(account = accountList[1])
                AccountItem(account = accountList[2])
            }
            AddAccount(icon = Icons.Outlined.ManageAccounts, title = "Manage Accounts")
            AddAccount(icon = Icons.Outlined.Person, title = "Add Another Account")
            Divider(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))
            // Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Text - Privacy Policy
                Text(text = "Privacy Policy")
                // Card - Empty
                Card(modifier = Modifier
                    .padding(top = 10.dp)
                    .size(3.dp), shape = CircleShape, backgroundColor = Color.Black) {

                }//: End Card - Empty
                // Text
                Text(text = "Terms Of Service")
            }
        }
    }
}

@Composable
fun AccountItem(account: Accounts) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp)) {
            if(account.icon != null) {
                // Image - Image
                Image(painter = painterResource(id = account.icon),
                    contentDescription = "2nd Profile",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(color = Color.Gray)
                )
            } else {
                // Card
                Card(modifier = Modifier
                    .padding(end = 8.dp)
                    .size(40.dp)
                    .clip(CircleShape),
                    backgroundColor = Color.Gray) {
                    // Text
                    Text(text = account.userName[0].toString(),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(8.dp))
                }
            }
            // Column - 2nd Profile
            Column(modifier = Modifier
                .weight(2.0f)
                .padding(start = 16.dp, bottom = 16.dp)) {
                // Text
                Text(text = account.userName, fontWeight = FontWeight.SemiBold)
                // Text
                Text(text = account.email)
            }//: End Column
            // Text
            Text(text = "${account.unreadEmails}+", modifier = Modifier.padding(end = 16.dp))
        }//: End Row

}

@Composable
fun AddAccount(icon: ImageVector, title: String) {
    // Row
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp)) {
        // Icon Button
        IconButton(onClick = {}) {
            // Icon
            Icon(imageVector = icon,
                contentDescription = "",
                modifier = Modifier.padding(bottom = 8.dp))
        }
        // Text
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 8.dp, start = 8.dp)
        )
    }//: End Row
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun AccountDialogUIPreview() {
    AccountsDialogUI(openDialog = mutableStateOf(false))
}