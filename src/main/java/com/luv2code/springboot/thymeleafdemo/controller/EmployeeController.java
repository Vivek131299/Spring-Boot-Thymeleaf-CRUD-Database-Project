package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // load employee data
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {

        // create employees
        Employee empl1 = new Employee(1, "Leslie", "Andrews", "leslie@luv2code.com");
        Employee empl2 = new Employee(1, "Emma", "Baumgarten", "emma@luv2code.com");
        Employee empl3 = new Employee(1, "Avani", "Gupta", "avani@luv2code.com");

        // create the list
        theEmployees = new ArrayList<>();

        // add to the list
        theEmployees.add(empl1);
        theEmployees.add(empl2);
        theEmployees.add(empl3);
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // add to the Spring Model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
        // Spring Boot will look into src/main/resources/templates/list-employees.html since we are
        // using Thymeleaf.
    }
}
