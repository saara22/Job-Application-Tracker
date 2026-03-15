package com.example.jobapplicationtracker.model

data class JobApplication(
    val id: Int,
    val company: String,
    val role: String,
    val status: String
)