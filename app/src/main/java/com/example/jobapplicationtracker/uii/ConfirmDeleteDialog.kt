package com.example.jobapplicationtracker.uii

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun ConfirmDeleteDialog(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {

    AlertDialog(
        onDismissRequest = onDismiss,

        title = { Text("Delete Application") },

        text = { Text("Are you sure you want to delete this application?") },

        confirmButton = {
            Button(onClick = onConfirm) {
                Text("Delete")
            }
        },

        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}