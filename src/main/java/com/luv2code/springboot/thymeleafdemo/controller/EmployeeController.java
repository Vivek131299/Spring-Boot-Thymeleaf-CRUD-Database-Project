package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Constructor Injection
    // NOTE : Since we have only one constructor, @Autowired Annotation is Optional.
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get the employees from the database
        List<Employee> theEmployees = employeeService.findAll();

        // add to the Spring Model
        theModel.addAttribute("employees", theEmployees);

        return "/employees/list-employees";
        // Spring Boot will look into src/main/resources/templates/employees/list-employees.html since we are
        // using Thymeleaf.
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create the model attribute to bind form data
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        // Our Thymeleaf template will access this 'employee' model attribute for binding form data.

        return "employees/employee-form";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
    // @ModelAttribute will get the data passed from the form in the 'employee' object using data binding.

        // save the employee
        employeeService.save(theEmployee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
}
