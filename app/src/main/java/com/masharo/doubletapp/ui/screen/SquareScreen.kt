package com.masharo.doubletapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.masharo.doubletapp.ui.theme.DoubletappTheme

@Composable
fun SquareScreen(
    modifier: Modifier = Modifier,
    square: String
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = square,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun SquareScreenPreview() {
    DoubletappTheme {
        SquareScreen(square = "9")
    }
}