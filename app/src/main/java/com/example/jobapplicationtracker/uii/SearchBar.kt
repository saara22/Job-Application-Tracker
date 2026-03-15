package com.example.jobapplicationtracker.uii

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    searchText: String,
    onSearchChange: (String) -> Unit
) {

    val suggestions = listOf(
        "Google",
        "Amazon",
        "Meta",
        "Microsoft",
        "Software Engineer",
        "Data Analyst",
        "Product Designer"
    )

    Column {

        OutlinedTextField(
            value = searchText,
            onValueChange = onSearchChange,
            label = { Text("Search company or role") }
        )

        suggestions.filter {
            it.contains(searchText, true) && searchText.isNotEmpty()
        }.forEach {

            Text(
                text = it,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSearchChange(it) }
                    .padding(8.dp)
            )
        }
    }
}