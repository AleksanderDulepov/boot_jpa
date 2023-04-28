package com.dulepov.spring.rest.boot_jpa_repository.boot_jpa.service;



import com.dulepov.spring.rest.boot_jpa_repository.boot_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();    //READ

    public void saveEmployee(Employee emp);        //CREATE

    public Employee getCurrentEmployee(int id);    //UPDATE

    public void deleteEmployee(int id);    //DELETE

    public List<Employee> findAllByName(String name);   //Half custom jpa method

}
