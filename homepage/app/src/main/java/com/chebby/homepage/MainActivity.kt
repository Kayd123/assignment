package com.chebby.homepage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.CardElevation
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
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
            BottomBar()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable

fun home(
    backgroundImageResId: Int = R.drawable.index,
    content : @Composable () -> Unit ={}
) {
    var searchQuery by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Scaffold(
        content = {
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
                                .padding(1.dp)
                                .fillMaxWidth()
                                .fillMaxSize(),
                            colors = CardDefaults.cardColors(containerColor = Color.Red),
                            elevation = CardDefaults.cardElevation(20.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(17.dp)
                            ) {
                                Text(
                                    text = "Location",
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 11.sp,
                                    color = Color.White,
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.LocationOn,
                                            contentDescription = "Location Icon",
                                            tint = Color.White,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Spacer(
                                            modifier = Modifier
                                                .width(4.dp)
                                        )
                                        Text(
                                            text = "New York, USA",
                                            fontFamily = FontFamily.Monospace,
                                            fontSize = 11.sp,
                                            color = Color.White,
                                            textAlign = TextAlign.Center
                                        )
                                        Icon(
                                            imageVector = Icons.Default.KeyboardArrowDown,
                                            contentDescription = "Keyboard Arrow",
                                            tint = Color.White
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .size(40.dp)
                                            .background(
                                                Color.White.copy(alpha = 0.4f),
                                                shape = RoundedCornerShape(2.dp)
                                            )
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Notifications,
                                            contentDescription = "Notification Icon",
                                            tint = Color.White,
                                            modifier = Modifier
                                                .size(50.dp)
                                        )
                                    }

                                }
                                Spacer(
                                    modifier = Modifier
                                        .height(16.dp)
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    TextField(
                                        value = searchQuery,
                                        onValueChange = { searchQuery = it },
                                        singleLine = true,
                                        leadingIcon = {
                                            Icon(
                                                imageVector = Icons.Default.Search,
                                                contentDescription = null
                                            )
                                        },
                                        label = {
                                            Text(text = "Search")
                                        },
                                        modifier = Modifier
                                            .padding(1.dp),
                                        shape = RoundedCornerShape(2.dp)

                                    )
                                    Box(
                                        modifier = Modifier
                                            .size(40.dp)
                                            .background(
                                                Color.White, //.copy(alpha = 0.4f)
                                                shape = RoundedCornerShape(2.dp)
                                            )
                                    ) {
                                        IconButton(
                                            onClick = { },
                                            modifier = Modifier
                                                .size(50.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Search,
                                                contentDescription = "Filter Icon",

                                                )
                                        }
                                    }
                                }
                            }
                        }

                    }
                    Spacer(
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                        Text(
                            text = "#SpecialForYou",
                            Modifier
                                .padding(10.dp),
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 16.sp,
                            color = Color(0xff000000),
                            textAlign = TextAlign.Center,
                        )
                        Text(
                            text = "See All",
                            Modifier
                                .padding(10.dp),
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 16.sp,
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                        )

                    }
                    Spacer(
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    LazyRow {

                        item {

                            Card(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .fillMaxHeight()
                                    .fillMaxWidth(),

                                shape = RoundedCornerShape(10.dp),
                            ) {

                                Box(
                                    modifier = Modifier
                                ) {

                                    Image(
                                        painter = painterResource(id = backgroundImageResId),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .fillMaxWidth()
                                            .fillMaxHeight(),
                                    )
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(Color.Black.copy(alpha = 0.3f))
                                            .padding(16.dp),
                                    ) {

                                        Column {
                                            Button(
                                                onClick = { },
                                                modifier = Modifier
                                                    .padding(10.dp),
                                                shape = RoundedCornerShape(8.dp),
                                                colors = ButtonDefaults.buttonColors(Color.White)
                                                //shape = RectangleShape,

                                            ) {
                                                Text(
                                                    "Limited time!",
                                                    color = Color(0xff000000)
                                                )
                                            }
                                            Text(
                                                text = "Get Special Offer",
                                                color = Color.White,
                                                fontFamily = FontFamily.SansSerif,
                                                fontSize = 16.sp,
                                                textAlign = TextAlign.Center,
                                            )
                                            Spacer(
                                                modifier = Modifier
                                                    .padding(8.dp)
                                            )
                                            Row {
                                                Row {
                                                    Text(
                                                        text = "Up to",
                                                        color = Color.White,
                                                        fontFamily = FontFamily.SansSerif,
                                                        fontSize = 16.sp,
                                                        textAlign = TextAlign.Center,
                                                        )
                                                    Box(
                                                        contentAlignment = Alignment.BottomEnd,
                                                    ) {
                                                        Text(
                                                            text = "40",
                                                            color = Color.White,
                                                            fontFamily = FontFamily.Monospace,
                                                            fontSize = 40.sp,
                                                            fontWeight = FontWeight.Bold,
                                                            textAlign = TextAlign.Center,
                                                            modifier = Modifier.align(Alignment.BottomStart)
                                                        )
                                                        Box(
                                                            modifier = Modifier
                                                                .size(15.dp)
                                                                .background(
                                                                    Color.Red,
                                                                    shape = CircleShape
                                                                )
                                                                .align(Alignment.BottomEnd)
                                                                .offset(x = (-2).dp, y = (2).dp)
                                                            ,
                                                            contentAlignment = Alignment.Center
                                                        ) {
                                                            Text(
                                                                text = "%",
                                                                color = Color.White,
                                                                fontFamily = FontFamily.SansSerif,
                                                                fontSize = 13.sp,
                                                                textAlign = TextAlign.Center
                                                            )
                                                        }
                                                     }
                                                }
                                            }
                                            Spacer(modifier = Modifier
                                                .padding(8.dp)
                                            )
                                            Column (
                                                verticalArrangement = Arrangement.SpaceBetween,
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            ){
                                                Row{
                                                    Text(
                                                        text = "All Services Available |T&C Applied",
                                                        color = Color.White,
                                                        fontFamily = FontFamily.Monospace,
                                                        fontSize = 13.sp,
                                                        textAlign = TextAlign.Center
                                                    )
                                                    Spacer(modifier = Modifier
                                                        .padding(8.dp)
                                                    )
                                                    Button(onClick = { /*TODO*/ },
                                                        colors = ButtonDefaults.buttonColors(
                                                            containerColor = Color.Red,
                                                            contentColor = Color.White
                                                        ),
                                                        modifier = Modifier
                                                            .padding(2.dp) ) {
                                                        Text(
                                                            text = "Claim",
                                                            fontFamily = FontFamily.SansSerif,
                                                            fontSize = 16.sp
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }


                }

            }
        },
        bottomBar ={ BottomBar()}
    )

}

@Composable
fun BottomBar()  {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = Color.White
    ) {
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"")
        },
            label = { Text(text = "Home") }, selected = (selectedIndex.value == 0), onClick = {
                selectedIndex.value = 0
            })
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Favorite,"")
        },
            label = { Text(text = "Wishlist") }, selected = (selectedIndex.value == 1), onClick = {
                selectedIndex.value = 1
            })
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.ShoppingCart,"")
        },
            label = { Text(text = "Cart") }, selected = (selectedIndex.value == 1), onClick = {
                selectedIndex.value = 1
            })
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Email,"")
        },
            label = { Text(text = "Chat") }, selected = (selectedIndex.value == 1), onClick = {
                selectedIndex.value = 1
            })
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Person, "")
        },
            label = { Text(text = "Profile") }, selected = (selectedIndex.value == 2), onClick = {
                selectedIndex.value = 2
            })
    }
}