package com.hashinology.employeeapp.repo

import com.hashinology.employeeapp.di.ApiService

class EmployeeRepository(val apiService: ApiService) {
    suspend fun getAllData() = apiService.getAllInfo()
}