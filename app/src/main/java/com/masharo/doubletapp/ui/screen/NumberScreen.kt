package com.masharo.doubletapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masharo.doubletapp.R
import com.masharo.doubletapp.ui.theme.DoubletappTheme

@Composable
fun NumberScreen(
    modifier: Modifier = Modifier,
    onClickSquare: (Int) -> Unit
) {
    val countConfig = rememberSaveable(
        stateSaver = Saver(
            save = { it + 1 },
            restore = { it }
        )
    ) { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = countConfig.value.toString(),
                style = MaterialTheme.typography.h1
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 10.dp,
                    start = 5.dp,
                    end = 5.dp
                ),
            onClick = {
                onClickSquare(countConfig.value)
            }
        ) {
            Text(
                text = stringResource(R.string.button_square),
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun NumberScreenPreview() {
    DoubletappTheme {
        NumberScreen(onClickSquare = { })
    }
}