package com.dulepov.spring.rest.boot_jpa_repository.boot_jpa.service;

import com.dulepov.spring.rest.boot_jpa_repository.boot_jpa.dao.EmployeeRepository;
import com.dulepov.spring.rest.boot_jpa_repository.boot_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //READ
    @Override
    //@Transactional JpaRepository сам реализует под капотом, можно не додавлять
    public List<Employee> getAllEmployees(){
        List<Employee> emps=employeeRepository.findAll();
        return emps;
    }

    //CREATE
    @Override
    public void saveEmployee(Employee emp)
    {
        employeeRepository.save(emp);
    }

    //UPDATE
    @Override
    public Employee getCurrentEmployee(int id){
        Employee employee=null;
        Optional<Employee> empOptional=employeeRepository.findById(id);     //optional будет пуст, если такого id нет
        if (empOptional.isPresent())
        {
            employee=empOptional.get();     //доставем из обертки
        }
        return employee;
    }

    //DELETE
    @Override
    public void deleteEmployee(int id)
    {
        employeeRepository.deleteById(id);
    }

    //READ ALL BY NAME
    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> emps=employeeRepository.findAllByName(name);
        return emps;
    }

}
