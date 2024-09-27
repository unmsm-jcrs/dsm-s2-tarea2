package com.example.app30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import com.example.app30days.ui.theme.App30daysTheme
import com.example.app30days.data.Movie
import com.example.app30days.data.movies

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App30daysTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    DaysApp()
                }
            }
        }
    }
}


@Composable
fun DaysApp() {
    Scaffold(
        topBar = {
            DaysTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            itemsIndexed(movies) { index, movie ->
                MovieItem(
                    movie = movie,
                    numDay = index + 1,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun MovieItem(
    movie: Movie,
    numDay: Int,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer,
    )
    Card(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .background(color = color)
            .clickable { expanded = !expanded }
    ) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring<IntSize>(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
        ) {
            Text(
                text = stringResource(R.string.days, numDay),
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = dimensionResource(R.dimen.padding_small)),
                textAlign = TextAlign.Center,
            )
            if(!expanded) {
                MovieUnexpanded(movie.title)
            } else {
                Row() {
                    MovieIcon(movie.imageResourceId)
                    Column(
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        MovieInformation(movie.title, movie.description)
                    }
                }
            }
        }
    }
}

@Composable
fun MovieIcon(
    @DrawableRes movieIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = Modifier
            .size(
                width = dimensionResource(R.dimen.movie_width),
                height = dimensionResource(R.dimen.movie_height)
            )
            .padding(dimensionResource(R.dimen.padding_small)),
        painter = painterResource(movieIcon),
        contentScale = ContentScale.Fit,
        contentDescription = null,

    )
}

@Composable
fun MovieInformation(
    @StringRes movieTitle: Int,
    @StringRes movieDescription: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(movieTitle),
        style = MaterialTheme.typography.displayMedium,
        modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
    )
    Text(
        text = stringResource(movieDescription),
        style = MaterialTheme.typography.labelSmall,
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_small))
    )
}

@Composable
fun MovieUnexpanded(
    @StringRes movieTitle: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(movieTitle),
        style = MaterialTheme.typography.displayMedium,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(top = dimensionResource(R.dimen.padding_small))
            .fillMaxSize()

    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaysTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.logo_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(R.drawable.logo_de_app),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MoviesPreview() {
    App30daysTheme {
        DaysApp()
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesDarkThemePreview() {
    App30daysTheme(darkTheme = true) {
        DaysApp()
    }
}

