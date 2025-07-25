package com.example.stickyscrolleffect

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TiktokScreen(navController: NavController) {

    val scrollState = rememberScrollState()
    val threshold = 100

    val showHeaderTitle by remember {
        derivedStateOf { scrollState.value > threshold }
    }

    val alpha by animateFloatAsState(
        targetValue = if (showHeaderTitle) 1f else 0f,
        animationSpec = tween(durationMillis = 120)
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Tiktok Settings and Privacy",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.alpha(alpha)
                )
            }
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Settings and Privacy",
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 28.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )

            }

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Account",
                    modifier = Modifier.padding(start = 32.dp, top = 16.dp),
                    fontSize = 13.sp
                )
                Surface(
                    tonalElevation = 2.dp,
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        SettingsItem(title = "Account", iconResId = R.drawable.ic_account, onClick = { })
                        SettingsItem(title = "Privacy", iconResId = R.drawable.ic_security, onClick = { })
                        SettingsItem(title = "Security & permissions", iconResId = R.drawable.ic_security, onClick = { })
                        SettingsItem(title = "Analytics", iconResId = R.drawable.ic_security, onClick = { })
                        SettingsItem(title = "Share profile", iconResId = R.drawable.ic_security, onClick = { })
                    }
                }

                Text(
                    text = "Content & Display",
                    modifier = Modifier.padding(start = 32.dp, top = 16.dp),
                    fontSize = 13.sp
                )
                Surface(
                    tonalElevation = 2.dp,
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        SettingsItem(title = "Notification", iconResId = R.drawable.ic_notification, onClick = { })
                        SettingsItem(title = "LIVE", iconResId = R.drawable.ic_display, onClick = {  })
                        SettingsItem(title = "Music", iconResId = R.drawable.ic_display, onClick = {  })
                        SettingsItem(title = "Activity center", iconResId = R.drawable.ic_display, onClick = {  })
                        SettingsItem(title = "Content preferences", iconResId = R.drawable.ic_display, onClick = {  })
                        SettingsItem(title = "Audience controls", iconResId = R.drawable.ic_display, onClick = {  })
                        SettingsItem(title = "Ads", iconResId = R.drawable.ic_display, onClick = {  })
                        SettingsItem(title = "Playback", iconResId = R.drawable.ic_display, onClick = {  })
                        SettingsItem(title = "Display", iconResId = R.drawable.ic_display, onClick = {  })
                        SettingsItem(title = "Language", iconResId = R.drawable.ic_display, onClick = {  })
                        SettingsItem(title = "Screen Time", iconResId = R.drawable.ic_display, onClick = {  })
                        SettingsItem(title = "Family Pairing", iconResId = R.drawable.ic_display, onClick = {  })
                        SettingsItem(title = "Accessibility", iconResId = R.drawable.ic_display, onClick = {  })
                    }
                }


                Text(
                    text = "Cache & Cellular",
                    modifier = Modifier.padding(start = 32.dp, top = 16.dp),
                    fontSize = 13.sp
                )
                Surface(
                    tonalElevation = 2.dp,
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        SettingsItem(title = "Offline videos", iconResId = R.drawable.ic_report, onClick = { })
                        SettingsItem(title = "Free up space", iconResId = R.drawable.ic_support, onClick = { })
                        SettingsItem(title = "Data Saver", iconResId = R.drawable.ic_terms, onClick = { })
                    }
                }


                Text(
                    text = "Support & About",
                    modifier = Modifier.padding(start = 32.dp, top = 16.dp),
                    fontSize = 13.sp
                )
                Surface(
                    tonalElevation = 2.dp,
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        SettingsItem(title = "Report a problem", iconResId = R.drawable.ic_report, onClick = { })
                        SettingsItem(title = "Support", iconResId = R.drawable.ic_support, onClick = { })
                        SettingsItem(title = "Terms and Policies", iconResId = R.drawable.ic_terms, onClick = { })
                    }
                }


                Text(
                    text = "Login",
                    modifier = Modifier.padding(start = 32.dp, top = 16.dp),
                    fontSize = 13.sp
                )
                Surface(
                    tonalElevation = 2.dp,
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f),
                    modifier = Modifier.fillMaxWidth().padding(bottom = 36.dp, start = 16.dp, end = 16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        SettingsItem(title = "Switch Account", iconResId = R.drawable.ic_switch, onClick = { })
                        SettingsItem(title = "Log out", iconResId = R.drawable.ic_logout, onClick = { })
                    }
                }
            }
            }

    }
}

@Composable
fun SettingsItem(
    title: String,
    iconResId: Int,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = title,
                modifier = Modifier.size(24.dp).alpha(0.8f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 16.sp
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_right_arrow),
            contentDescription = "Go to $title",
            modifier = Modifier.size(20.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}