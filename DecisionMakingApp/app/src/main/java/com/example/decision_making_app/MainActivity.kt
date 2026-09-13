package com.example.decision_making_app

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decision_making_app.ui.theme.DecisionMakingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DecisionMakingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DecisionScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


// The UI or screen of the app
@Composable
fun DecisionScreen(
    modifier: Modifier = Modifier
) {
    DecisionButtons(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

// The buttons of the app
@Composable
fun DecisionButtons(modifier: Modifier = Modifier) {
    // Variable that holds the value for the decision
    var textDisplay by remember {mutableStateOf(12)}
    // Controls the variability of the decisions of the buttons
    val textResource = when (textDisplay) {
        1 -> "Yes"
        2 -> "No"
        3 -> "No"
        4 -> "No"
        5 -> "No"
        6 -> "No"
        7 -> "No"
        8 -> "No"
        9 -> "No"
        10 -> "No"
        else -> "Should we go?"
    }
    // Counter for the amount of times a button is clicked
    var clickCounter by remember {mutableStateOf(0)}


    // Text for my Student ID number and CCID
    Text(
        text = "\n\n\tslindstr \t\n 1968350"
    )

    // Creates the UI for the app
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        // Displays the outcome
        Text(
            text = textResource,
            fontSize = 24.sp
        )
        // Creates the row for the buttons
        Row(modifier = Modifier.padding(16.dp)) {

            // The yes button
            Button(
                onClick = {
                    // A function built into Kotlin that randomly picks a number between the two values
                    textDisplay = (1..2).random()
                    clickCounter += 1
                }
            ) {
                Text("Yes")
            }

            // Adds space between the buttons
            Spacer(modifier = Modifier.width(12.dp))

            // The maybe button
            Button(
                onClick = {
                    // A function built into Kotlin that randomly picks a number between the two values
                    textDisplay = (1..4).random()
                    clickCounter += 1
                }
            ) {
                Text("Maybe")
            }
            // Adds space between the buttons
            Spacer(modifier = Modifier.width(12.dp))

            // The no button
            Button(
                onClick = {
                    // A function built into Kotlin that randomly picks a number between the two values
                    textDisplay = (1..10).random()
                    clickCounter += 1
                }
            ) {
                Text("No")
            }
        }

        // Displays the count on screen
        Text(
            text = "$clickCounter",
            fontSize = 24.sp
        )
    }
}