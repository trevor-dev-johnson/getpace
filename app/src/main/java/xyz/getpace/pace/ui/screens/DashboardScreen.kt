package xyz.getpace.pace.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen() {
    var totalSaved by remember { mutableStateOf(0) }
    var streak by remember { mutableStateOf(0) }
    var hasSavedToday by remember { mutableStateOf(false) }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // Total Saved
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Total Saved", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "$$totalSaved",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }

            // Streak
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Current Streak", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "$streak days",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Consistency beats intensity.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            // Action
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Today’s Action", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            totalSaved += 5
                            streak += 1
                            hasSavedToday = true
                        },
                        enabled = !hasSavedToday,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(if (hasSavedToday) "Saved Today" else "Save Today")
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = if (hasSavedToday)
                            "Nice work — come back tomorrow."
                        else
                            "Small actions add up.",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            // Rewards Preview
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Rewards", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Rewards coming soon", style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "Consistency unlocks SKR bonuses.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
