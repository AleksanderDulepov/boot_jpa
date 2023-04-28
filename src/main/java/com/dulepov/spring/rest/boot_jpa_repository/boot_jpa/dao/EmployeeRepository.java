package com.dulepov.spring.rest.boot_jpa_repository.boot_jpa.dao;

import com.dulepov.spring.rest.boot_jpa_repository.boot_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {  //(entity, тип данных PK для employee(приведеннный к rapper-классу))
    //добавление встроенных методов для работы с атрибутами entity (помимо классического CRUD)
    public List<Employee> findAllByName(String name);

}
