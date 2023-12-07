package EmployeeList.Service;

import EmployeeList.Employees.Employee;
import EmployeeList.Employees.EmployeeDTO;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Converter implements Constants {
    //Clas for converting java object to object list that is ready to be sent to database.

    public List<EmployeeDTO> convertEmployeeListToEmployeesDTO(List<Employee> employees) {
        List<EmployeeDTO> employeesDTO = new ArrayList<>();

        for (Employee employee : employees) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setID(employee.getEmpId());
            employeeDTO.setFullName(fullName(employee));
            employeeDTO.setExperience(experienceInYears(employee));
            employeeDTO.setSalary(monthlySalary(employee));
            employeeDTO.setJobTitle(employee.getPareigos());
            employeeDTO.setDob(dateOfBirth(employee));

            employeesDTO.add(employeeDTO);
        }

        return employeesDTO;
    }

    // Method adds objects name and surname and returns full name.
    private String fullName(Employee employee) {
        return employee.getVardas() + " " + employee.getPavarde();
    }

    // Method divides employees experience in months by amount of months in a year and returns
    // experience in years.
    private double experienceInYears(Employee employee) {
        return Math.round(employee.getPatirtis() / AMOUNT_OF_MONTHS_IN_A_YEAR);
    }

    // Method divides employees yearly salary by amount of months in a year and returns
    // monthly salary.
    private double monthlySalary(Employee employee) {
        return employee.getAlga() / AMOUNT_OF_MONTHS_IN_A_YEAR;
    }

    // Method sets current year and saves the year in to a int variable.
    // From that variable method subtracts employees age and returns year of
    // birth.
    private int dateOfBirth(Employee employee) {
        Year currentYear = Year.now();
        int currentYearOnly = currentYear.getValue();
        return currentYearOnly - employee.getAmzius();
    }
}


