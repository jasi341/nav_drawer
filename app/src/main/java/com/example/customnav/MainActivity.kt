package com.example.customnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.customnav.ui.theme.CustomNavTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomNavTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =Color(0xFF2196F3)
                ) {
                    App()
                }
            }
        }
    }
}



@Composable
fun MyColumn(
    list: List<String> = listOf(
        "Home", "Scores", "Live","Profile","Home", "Scores", "Live","Profile","Home",
        "Live","Profile","Home", "Scores", "Live","Profile","Home"
    ),
    navController: NavController ,
    isSubscribed: Boolean
) {

    val height = LocalConfiguration.current.screenHeightDp.dp
    val gradientColor = listOf(Color(0xFF0D1D41), Color(0xFF0032AE))

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(top = 50.dp,)
            .background(
                brush = Brush.verticalGradient(gradientColor),
                shape = RectangleShape
            )
    ) {
        Row(Modifier.padding(10.dp)) {
            Text(
                text = "Hello, ",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "XYZ",
                fontSize = 20.sp,
                color = Color.White,

                fontWeight = FontWeight.SemiBold
            )
        }

        Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 2.dp)) {
            if (isSubscribed) {
                UpgradeUi()
            } else {
                SubscribeUi()
            }
            Spacer(modifier = Modifier.height(15.dp))

            Divider(
                Modifier
                    .fillMaxWidth(), color = Color(0xFF1A4392), thickness = 2.dp
            )
            Column(Modifier.height(height*0.6f).verticalScroll(rememberScrollState())) {


                list.forEach { item ->

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 15.dp)

                            .clickable {
                                when (item) {
                                    "Home" -> navController.navigate("home_screen")
                                    "Scores" -> navController.navigate("scores")
                                    "Live" -> navController.navigate("live")
                                    "Profile" -> navController.navigate("profile")
                                }

                            },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_chevron_right_24),
                            contentDescription = null,
                            tint = Color.White,
                        )

                    }
                    Divider(
                        Modifier
                            .fillMaxWidth(), color = Color(0xFF1A4392), thickness = 2.dp
                    )
                }
            }
        }


        Column(
            Modifier
                .padding( end = 15.dp, start = 15.dp)
                .fillMaxWidth().weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "© 2023 Monumental Sports Network LLC. ALL RIGHTS RESERVED.",
                color = Color.White,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}

@Composable
fun UpgradeUi() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Column (){
            Text(
                text = "Choose a Plan",
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center

            )
            Text(
                text = "To get unlimited access to everything",
                fontSize = 12.sp,
                color = Color(0xff838996)

            )

        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(32.dp)
                .width(107.dp),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Subscribe Now!", color = Color.White, fontSize = 12.sp    ,textAlign = TextAlign.Center)

        }

    }
}

@Composable
fun SubscribeUi() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Column {
            Text(
                text = "Monthly Subscription Plan",
                fontSize = 16.sp,
                color = Color.White

            )
            Text(
                text = "Expiring on: Nov,10,2023",
                fontSize = 12.sp,
                color = Color(0xff838996)

            )

        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(32.dp)
                .width(107.dp),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Upgrade Plan!", color = Color.White, fontSize = 12.sp)

        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScreen(navController: NavController) {
    var isColumnVisible by remember { mutableStateOf(false) }
    val gradientColor = listOf(Color(0xFF0D1D41), Color(0xFF0032AE))

    Scaffold(modifier = Modifier.fillMaxWidth(), containerColor = Color.White, contentColor = Color.Blue) { contentPadding ->
        // Screen content
        Box(modifier = Modifier
            .padding(contentPadding)
            .background(Color.White)
            .fillMaxWidth()) {
            IconButton(
                onClick = { isColumnVisible = !isColumnVisible },
                modifier = Modifier.padding(horizontal = 10.dp),
            ) {
                val iconResourceId = if (isColumnVisible) {
                    R.drawable.baseline_close_24
                } else {
                    R.drawable.baseline_menu_24
                }

                val rotationAngle by animateFloatAsState(
                    targetValue = if (isColumnVisible) 90f else 0f
                )

                Icon(
                    painter = painterResource(id = iconResourceId),
                    contentDescription = null,
                    modifier = Modifier.graphicsLayer {
                        rotationZ = rotationAngle
                    }
                )
            }
        }
    }



    AnimatedVisibility(
        visible = isColumnVisible,
        enter = slideInHorizontally(
            initialOffsetX = { -400 },
            animationSpec = tween(durationMillis = 1000)
        ) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutHorizontally(
            targetOffsetX = { -400 },
            animationSpec = tween(durationMillis = 1000)
        ) + fadeOut(animationSpec = tween(durationMillis = 1000))
    ) {
        MyColumn(navController = navController, isSubscribed = false
        )
    }
}

@Composable
fun HomeScreen() {
    Column(Modifier.wrapContentSize()) {
        Text(text = "Home Screen")

    }

}

@Composable
fun ScoresScreen() {
    Text(text = "Score Screen")
}

@Composable
fun LiveScreen() {
    Text(text = "Live Screen")
}

@Composable
fun ProfileScreen() {
    Text(text = "Profile Screen")
}

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.fillMaxSize(),

        ) {
        composable("home") { MyScreen(navController) }
        composable("home_screen"){ HomeScreen()}
        composable("scores") { ScoresScreen() }
        composable("live") { LiveScreen() }
        composable("profile") { ProfileScreen() }
    }
}



