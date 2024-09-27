package com.example.artspace

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                SpaceApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        SpaceApp()
    }
}

@SuppressLint("MissingColorAlphaChannel", "ResourceAsColor")
@Composable
fun SpaceApp() {
    var currentStep by remember { mutableStateOf(1) }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when(currentStep) {
            1 -> SpaceCard(R.string.title_buho, R.string.info_buho,R.string.desc_buho,R.drawable.buho)
            2 -> SpaceCard(R.string.title_gato_verde, R.string.info_gato_verde,R.string.desc_gato_verde,R.drawable.gato_verde)
            3 -> SpaceCard(R.string.title_lagarto, R.string.info_lagarto,R.string.info_lagarto,R.drawable.lagarto)
            4 -> SpaceCard(R.string.title_ornitorinco_amarillo, R.string.info_ornitorinco_amarillo,R.string.desc_ornitorinco_amarillo,R.drawable.ornitorinco_amarillo)
            else -> SpaceCard(R.string.title_squinkkle, R.string.info_squinkkle,R.string.desc_squinkkle,R.drawable.squinkle)
        }

        Row(modifier = Modifier) {
            Button(
                onClick = { if (currentStep > 1) currentStep -= 1 else currentStep = 5 },
                modifier = Modifier
                    .padding(20.dp)
                    .width(120.dp)
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = { if (currentStep < 5) currentStep += 1 else currentStep = 1 },
                modifier = Modifier
                    .padding(20.dp)
                    .width(120.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}



@Composable
fun SpaceCard(artTitle: Int, artwork: Int, imageDescription: Int, artImage: Int) {
    Image(
        painter = painterResource(id = artImage),
        contentDescription = stringResource(imageDescription),
        modifier = Modifier
            .shadow(
                elevation = 10.dp,
                shape = RectangleShape,
                clip = false
            )
            .height(400.dp)
            .width(300.dp)
            .padding(30.dp)
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(30.dp)
            .background(color = Color(0xFFecebf4))
    ) {
        Text(
            text = stringResource(artTitle),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W300,
            lineHeight = 30.sp,
            modifier = Modifier
                .width(300.dp)
                .padding(10.dp)
        )
        Text(
            text = stringResource(artwork),
            fontWeight = FontWeight.Bold
        )
    }
}