package com.example.assignment_kotlin_ph32870

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeSc()
        }
    }
}

data class BottomNavItem(
    val title: String,
    val icon: Int,
    val id: String
)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType",
    "UnusedMaterialScaffoldPaddingParameter"
)


@Composable
fun HomeSc () {

    val context = LocalContext.current

    val items = listOf(
        BottomNavItem("Home", R.drawable.home, "home"),
        BottomNavItem("Favorites", R.drawable.iconluu, "favorites"),
        BottomNavItem("Notification", R.drawable.iconthongbao, "notification"),
        BottomNavItem("Profile", R.drawable.iconprofile, "profile")

    )
    var selectedItem by remember { mutableStateOf(items[0]) }

    Scaffold(
        bottomBar = {
            BottomNavigation (
                backgroundColor = Color(0xFFFFFFFF)
            ){
                items.forEach { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painterResource(id = item.icon),
                                contentDescription = item.title,
                                modifier = Modifier.size(25.dp)
                            )
                        },
                        label = {
                            Text(
                                text = item.title,
                                fontSize = 1.sp,
                            )
                        },
                        selected = selectedItem == item,
                        onClick = {
                            selectedItem = item
                            if (item.id == "favorites") {
                                val intent = Intent(context, SignupScreen::class.java)
                                context.startActivity(intent)
                            }

                            if (item.id == "home") {
                                val intent = Intent(context, Home::class.java)
                                context.startActivity(intent)
                            }

                            if (item.id == "notification") {
                                val intent = Intent(context, LoginScreen::class.java)
                                context.startActivity(intent)
                            }

                            if (item.id == "profile") {

                                val intent = Intent(context, ProfileScreen::class.java)
                                context.startActivity(intent)
                            }
                        },
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    ) {
        Column (
            modifier = Modifier.padding(bottom = 60.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {  }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_search_24),
                        contentDescription = "Search",
                        modifier = Modifier.size(18.dp)
                    )
                }

                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Gray,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Thin,
                                fontFamily = FontFamily.Serif
                            )
                        ) {
                            append("Make home \n ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Serif,
                                letterSpacing = 0.5.sp
                            )
                        ) {
                            append("BEAUTIFUL")
                        }
                    },
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
                IconButton(onClick = {
                    val intent = Intent(context, CartScreen::class.java)
                    context.startActivity(intent)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.cart),
                        contentDescription = "Cart",
                        modifier = Modifier.size(19.dp)
                    )
                }

            }
            Spacer(modifier = Modifier.height(16.dp))
            CategorySection()
            BestSellerSection()

        }
    }

}


@Composable
fun CategorySection() {
    Column(Modifier.padding(horizontal = 16.dp, vertical = 20.dp)) {
        LazyRow(Modifier.fillMaxWidth()) {
            items(listOf(
                CategoryItem("Popular", R.drawable.poppular),
                CategoryItem("Chair", R.drawable.chair),
                CategoryItem("Table", R.drawable.table),
                CategoryItem("ArmChair", R.drawable.sofa),
                CategoryItem("Bed", R.drawable.bed),
                CategoryItem("Lamp", R.drawable.lamp)
            )) { item ->
                CategoryButton(
                    text = item.text,
                    icon = painterResource(id = item.icon),
                    backgroundColor = Color(android.graphics.Color.parseColor("#EEEEEE")),

                    )
            }
        }
    }
}

data class CategoryItem(val text: String, @DrawableRes val icon: Int)

@Composable
fun CategoryButton(
    text: String = "",
    icon: Painter,
    backgroundColor: Color
) {
    Column(
        Modifier
            .width(70.dp)
            .height(100.dp)
            .clickable { }
            .padding(horizontal = 8.dp)

    ) {
        Box(
            Modifier
                .size(60.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(13.dp)
        ) {
            Image(
                painter = icon,
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit

            )
        }
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, end = 1.dp),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BestSellerSection() {
    val productList = listOf(
        Product("Black Simple Lamp", R.drawable.item_den, "$ 12.00"),
        Product("Minimal Stand", R.drawable.item2, "$ 25.00"),
        Product("Coffee Chair", R.drawable.item3, "$ 20.00"),
        Product("Simple Desk", R.drawable.item4, "$ 50.00"),
    )

    LazyColumn {
        itemsIndexed(items = productList.chunked(2)) { index, products ->
            Row(Modifier.fillMaxWidth()) {
                products.forEach { product ->
                    ProductItem(product)
                }
            }
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    val context = LocalContext.current
    Column(Modifier.padding(8.dp)) {
        Box(Modifier.padding(0.dp)) {
            Image(
                painter = painterResource(id = product.imageResource),
                contentDescription = null,
                modifier = Modifier
                    .width(200.dp)
                    .height(180.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .clickable { val intent = Intent(context, ProductDeltailScreen::class.java)
                    context.startActivity(intent)
                    }
            )

            Box(
                modifier = Modifier
                    .size(29.dp)
                    .offset(x = 130.dp, y = 140.dp)
                    .background(
                        color = Color(android.graphics.Color.parseColor("#AAAAAA")),
                        shape = RoundedCornerShape(7.dp)
                    )
            ) {
                IconButton(
                    onClick = {  },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.cart),
                        contentDescription = "Thêm vào giỏ hàng",
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }

        Text(
            text = product.name,
            modifier = Modifier.padding(top = 8.dp, start = 25.dp),
            style = TextStyle(fontSize = 16.sp),
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold

        )
        Text(
            text = product.price,
            modifier = Modifier.padding(top = 4.dp, start = 25.dp),
            style = TextStyle(fontSize = 14.sp, color = Color.Gray),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}

data class Product(val name: String, @DrawableRes val imageResource: Int, val price: String)

@Preview(showBackground = true)
@Composable
fun PreviewLayout2(){
    HomeSc()
}
