package com.hashinology.employeeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hashinology.employeeapp.R
import com.hashinology.employeeapp.model.DataModel
import javax.inject.Inject


class EmployeeAdapter @Inject constructor(): RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    var employeeList: List<DataModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.employee_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataEmployee = employeeList[position]
        holder.id.text = dataEmployee.id.toString()
        holder.name.text = dataEmployee.employee_name.toString()
        holder.age.text = "age "+ dataEmployee.employee_age.toString()
        holder.salary.text = "salary "+dataEmployee.employee_salary.toString()
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    class ViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)
        val id: TextView = itemView.findViewById(R.id.tvId)
        val age: TextView = itemView.findViewById(R.id.tvAge)
        val salary: TextView = itemView.findViewById(R.id.tvSalary)
    }
}