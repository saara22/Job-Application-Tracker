

package com.example.jobapplicationtracker.uii

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jobapplicationtracker.model.JobApplication

@Composable
fun JobTrackerApp() {

    var jobList by remember { mutableStateOf(listOf<JobApplication>()) }
    var searchText by remember { mutableStateOf("") }
    var showAddDialog by remember { mutableStateOf(false) }

    val filteredJobs = jobList.filter {
        it.company.contains(searchText, true) ||
                it.role.contains(searchText, true)
    }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Job Application Tracker")

        Spacer(modifier = Modifier.height(10.dp))

        SearchBar(searchText) {
            searchText = it
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { showAddDialog = true }) {
            Text("Add Application")
        }

        if (showAddDialog) {
            AddEditJobDialog(
                onDismiss = { showAddDialog = false },
                onSave = { company, role, status ->
                    jobList = jobList + JobApplication(
                        id = jobList.size + 1,
                        company = company,
                        role = role,
                        status = status
                    )
                    showAddDialog = false
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(filteredJobs) { job ->

                JobCard(
                    job = job,
                    onDelete = {
                        jobList = jobList.filter { it.id != job.id }
                    }
                )

            }
        }
    }
}