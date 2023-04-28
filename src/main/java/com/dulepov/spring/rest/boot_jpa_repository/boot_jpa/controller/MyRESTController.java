package com.dulepov.spring.rest.boot_jpa_repository.boot_jpa.controller;



import com.dulepov.spring.rest.boot_jpa_repository.boot_jpa.entity.Employee;
import com.dulepov.spring.rest.boot_jpa_repository.boot_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")   //общий префикс можно прописать в application.properties - server.servlet.context-path
public class MyRESTController {

    //вызываем Service как компонент в spring контейнере (в данном случае через интерфейс, но можно и класс EmployeeServiceImpl)
    @Autowired
    private EmployeeService employeeService;

    //READ ALL
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        List<Employee> emps = employeeService.getAllEmployees();
        return emps;
    }

    //READ ONE
    @GetMapping("/employees/{empId}")
    public Employee getCurrentEmployee(@PathVariable int empId) {

        Employee emp = employeeService.getCurrentEmployee(empId);
        return emp;
        //нужно обрабатывать ошибки, всегда возвращает 200
    }

    //CREATE
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {

        //в теле не прописываем id, иначе если он будет то произойдет попытка обновить пользователя-принудительно зануляем, чтобы избежать (create/update по полю id понимает)
        employee.setId(0);
        employeeService.saveEmployee(employee);

        return employee;
    }

    //UPDATE
    @PutMapping("/employees/{empId}")    //встроенный метод jpa хорошо работает с put через employees/5 (передача в json всех полей)
    public Employee updateEmployee(@PathVariable int empId, @RequestBody Employee employee){

        Employee emp=employeeService.getCurrentEmployee(empId);
        employee.setId(empId);
        employeeService.saveEmployee(employee);
        return employee;
        //нужно обрабатывать ошибки, всегда возвращает 200

    }

    //DELETE
    @DeleteMapping("/employees/{empId}")
    public void deleteEmployee(@PathVariable int empId){

        employeeService.deleteEmployee(empId);
        //нужно обрабатывать ошибки, всегда возвращает 200
    }

    //READ ALL BY NAME
    @GetMapping("/employees/name/{name}")
    public List<Employee> getAllEmployeesByName(@PathVariable String name) {
        List<Employee> emps = employeeService.findAllByName(name);
        return emps;
    }


}
