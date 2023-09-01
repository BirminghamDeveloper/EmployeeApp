package com.hashinology.employeeapp.model

data class EmployeeResponse(
    val `data`: List<DataModel>,
    val message: String,
    val status: String
)