package com.employmeeSystem;


import com.employmeeSystem.dao.EmployeeDAO;
import com.employmeeSystem.dao.EmployeeDAPImpl;
import com.employmeeSystem.entity.Employee;


public class EmploymeeSystemApplication {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAPImpl();

        // Create and save an employee
        Employee employee1 = new Employee("John", "Doe", "john@BM.com",
                "020454545546", "Software Engineer", "Java", 3700.0f);
        employeeDAO.save(employee1);
        Employee employee2 = new Employee("Bonita", "Dany", "bonita@BM.com",
                "025784586961", "HR Specialist", "HR", 4200.0f);
        employeeDAO.save(employee2);
        Employee employee3 = new Employee("Robin", "Musk", "robin@BM.com",
                "020004005067", "Data Scientist", "Analytics", 3500.0f);
        employeeDAO.save(employee3);

        // Retrieve and display an employee
        Employee retrievedEmployee = employeeDAO.findById(employee1.getId());
        System.out.println("Retrieved Entity: " + retrievedEmployee);

        // Update the employee
        retrievedEmployee.setDepartment("Engineering");
        employeeDAO.update(retrievedEmployee);

        // Display all employees
        System.out.println("All Entities: " + employeeDAO.findAll());

        // Delete an employee
        employeeDAO.delete(retrievedEmployee.getId());
    }


}





