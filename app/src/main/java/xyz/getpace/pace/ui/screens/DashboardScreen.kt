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
    var selectedAmount by remember { mutableStateOf(5) }
    var skrBalance by remember { mutableStateOf(0) }

    fun skrForAmount(amount: Int): Int {
        return when (amount) {
            5 -> 1
            10 -> 2
            25 -> 5
            else -> 0
        }
    }

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

            // Today’s Action
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Today’s Action",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Amount Picker
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        listOf(5, 10, 25).forEach { amount ->
                            OutlinedButton(
                                onClick = { selectedAmount = amount },
                                modifier = Modifier.weight(1f),
                                colors = if (selectedAmount == amount) {
                                    ButtonDefaults.outlinedButtonColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer
                                    )
                                } else {
                                    ButtonDefaults.outlinedButtonColors()
                                }
                            ) {
                                Text("$$amount")
                            }
                        }
                    }

                    // 🔹 SKR PREVIEW (Seeker-facing, no funding needed)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Earn ${skrForAmount(selectedAmount)} SKR for today’s save",
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Save Action
                    Button(
                        onClick = {
                            totalSaved += selectedAmount
                            streak += 1
                            skrBalance += skrForAmount(selectedAmount)
                            hasSavedToday = true
                        },
                        enabled = !hasSavedToday,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            if (hasSavedToday)
                                "Saved $$selectedAmount Today"
                            else
                                "Save $$selectedAmount"
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = if (hasSavedToday)
                            "Nice work — come back tomorrow."
                        else
                            "Choose an amount that feels sustainable.",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }


            // Rewards
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Rewards", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "$skrBalance SKR earned",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Rewards are earned through consistent saving.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

        }
    }
}
