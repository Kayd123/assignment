package com.chebby.homepage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.CardElevation
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chebby.homepage.ui.theme.HomepageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            home()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun home() {

    LazyColumn {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .fillMaxSize(),
                    colors = CardDefaults.cardColors(containerColor = Color.Red)
                ) {
                    Column(
                        //horizontalAlignment = Alignment.CenterHorizontally,
                       // verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(17.dp)
                    ) {
                        Text(
                            text = "Location",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 11.sp,
                            color = Color.White,
                            modifier = Modifier.
                                padding(bottom = 4.dp)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth() // Ensures the row takes up the full width
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = "Location Icon",
                                    tint = Color.White, // Adjust the color as needed
                                    modifier = Modifier.size(16.dp) // Adjust the size as needed
                                )
                                Spacer(modifier = Modifier.width(4.dp)) // Add space between icon and text
                                Text(
                                    text = "New York, USA",
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 11.sp,
                                    color = Color.White, // Color(0xffffffff) is equivalent to Color.White
                                    textAlign = TextAlign.Center
                                )
                            }
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = "Notification Icon",
                                tint = Color.White, // Adjust the color as needed
                                modifier = Modifier.size(16.dp) // Adjust the size as needed
                            )
                        }
                    }
                }
            }
        }
    }
}