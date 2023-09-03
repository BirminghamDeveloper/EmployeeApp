package com.hashinology.employeeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hashinology.employeeapp.model.DataModel
import com.hashinology.employeeapp.model.EmployeeResponse
import com.hashinology.employeeapp.repo.EmployeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(private val employeeRepository: EmployeeRepository): ViewModel() {
    private val _employeeMutableLiveData: MutableLiveData<List<DataModel>> = MutableLiveData<List<DataModel>>(null)
    val employeeLiveData: LiveData<List<DataModel>> = _employeeMutableLiveData

    private val _employeeError: MutableLiveData<String> = MutableLiveData<String>()
    val employeeError: LiveData<String> = _employeeError

    fun getEmployeeData() =
        viewModelScope.launch(Dispatchers.IO) {
            val response = employeeRepository.getAllData()
            _employeeMutableLiveData.value = response.data
            /*if (response.status == "success"){
                _employeeMutableLiveData.value = response.data
            }else{
                _employeeError.value = response.message
            }*/
        }
}