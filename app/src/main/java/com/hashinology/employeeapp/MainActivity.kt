package com.hashinology.employeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hashinology.employeeapp.adapter.EmployeeAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val employeeViewModel: EmployeeViewModel by viewModels()
    @Inject lateinit var employeeAdapter: EmployeeAdapter
    lateinit var rv: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rvEmployee)
        setUpRecyclerView()

        employeeViewModel.getEmployeeData()
        employeeViewModel.employeeLiveData.observe(this, Observer {
//            employeeAdapter.employeeList = it
            Log.d("MainActivity", "onCreate: "+ it.toString())
        })
    }

    private fun setUpRecyclerView() {
        employeeAdapter = EmployeeAdapter()
        rv.apply {
            adapter = employeeAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }
}