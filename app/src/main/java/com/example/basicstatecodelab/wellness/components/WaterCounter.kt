package com.example.basicstatecodelab.wellness.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }

    StatelessCounter(
        modifier = modifier,
        count = count,
        onCountChange = { count++ }
    )
}

@Composable
fun StatelessCounter(
    count: Int,
    onCountChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (count > 0) {
            Text(
                text = "You've had $count glasses."
            )
        }

        Button(
            modifier = Modifier.padding(top = 8.dp),
            onClick = onCountChange,
            enabled = count < 10
        ) {
            Text(text = "Add one")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    BasicStateCodelabTheme {
        StatefulCounter()
    }
}