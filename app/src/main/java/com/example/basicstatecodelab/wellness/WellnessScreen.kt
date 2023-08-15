package com.example.basicstatecodelab.wellness

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme
import com.example.basicstatecodelab.wellness.components.StatefulCounter
import com.example.basicstatecodelab.wellness.components.WellnessTaskList

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(
        modifier = modifier
    ) {
        StatefulCounter()
        WellnessTaskList(
            list = wellnessViewModel.tasks,
            onCloseTask = { task -> wellnessViewModel.remove(task) },
            onCheckedTask = { task, checked -> wellnessViewModel.changeTaskChecked(task, checked) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreview() {
    BasicStateCodelabTheme {
        WellnessScreen()
    }
}