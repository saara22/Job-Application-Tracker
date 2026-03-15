
package com.example.jobapplicationtracker.uii

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jobapplicationtracker.model.JobApplication

@Composable
fun JobCard(
    job: JobApplication,
    onDelete: () -> Unit
) {

    var showDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(modifier = Modifier.padding(12.dp)) {

            Text("Company: ${job.company}")
            Text("Role: ${job.role}")
            Text("Status: ${job.status}")

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { showDialog = true }) {
                Text("Delete")
            }
        }
    }

    if (showDialog) {
        ConfirmDeleteDialog(
            onConfirm = {
                onDelete()
                showDialog = false
            },
            onDismiss = { showDialog = false }
        )
    }
}