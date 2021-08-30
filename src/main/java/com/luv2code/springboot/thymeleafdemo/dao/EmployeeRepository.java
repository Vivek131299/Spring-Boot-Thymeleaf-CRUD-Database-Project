package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// This is our Spring Data JPA Repository instead of Hibernate or JPA API.
// This provides all basic CRUD operations for free.
// So we don't need to write any methods for CRUD operations.
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
// Above, 'Employee' is a Entity type and 'Integer' is a primary key type.

    // that's it... no need to write any code.
    // Also, there is no need to write any Implementation class of this Interface.


    // add a method to sort by last name
    // Order by last name ascending
    public List<Employee> findAllByOrderByLastNameAsc();
    // Spring Data JPA will parse the method name.
    // It looks for a specific format and pattern and Creates appropriate query behind the scenes.
    // SO, 'findAllBy' is the part of pattern and 'OrderByLastNameAsc' will get parse for OrderBy class for
    // given query statement.
    // So, behind the scenes, Spring Data JPA will do 'from Employee order by lastName asc'.
    //
    // So now we call this method in findAll() method in EmployeeServiceImpl class.
}
