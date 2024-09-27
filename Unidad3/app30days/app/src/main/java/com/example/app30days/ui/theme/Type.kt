package com.example.app30days.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.app30days.R

// Set of Material typography styles to start with

val Abeezee = FontFamily(
    Font(R.font.abeezee_regular)
)

val Oswald = FontFamily(
    Font(R.font.oswald_regular),
    Font(R.font.oswald_bold, FontWeight.Bold)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = Oswald,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    ),
    displayMedium =  TextStyle(
        fontFamily = Oswald,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Abeezee,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */



)