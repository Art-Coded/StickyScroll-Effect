package com.example.stickyscrolleffect

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 8.dp, end = 8.dp, bottom = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text(
                text = "Sticky Scrolling Effects",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )

            StickyCard(label = "Sticky box (with contents)") {
                navController.navigate("stickyBox")
            }

            StickyCard(label = "Sticky button") {
                navController.navigate("stickyButton")
            }

            StickyCard(label = "Sticky header") {
                navController.navigate("stickyHeader")
            }
        }
    }
}

@Composable
fun StickyCard(
    label: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(CircleShape)
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(24.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
