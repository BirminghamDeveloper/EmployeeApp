package com.hashinology.employeeapp.di

import com.hashinology.employeeapp.model.EmployeeResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/employees/")
    suspend fun getAllInfo(): EmployeeResponse
}