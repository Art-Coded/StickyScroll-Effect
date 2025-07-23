package com.example.stickyscrolleffect

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeaderScreen(navController: NavController) {

    val categories = listOf("Blue", "Yellow", "Orange", "Red", "Green", "Purple", "Violet", "Black", "White", "Pink", "Teal", "Brown", "Gray", "Light Blue", "Dark Blue", "Dark Brown")

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
                     text = " STICKY HEADER SCREEN"
                 )
             }
         }

        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    reverseLayout = false
                ) {
                    categories.forEach { category ->
                        stickyHeader {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(
                                    text = category,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }

                        items(5) { item ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(
                                    text = "$category ${item + 1}",
                                    fontSize = 14.sp,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

    }
}