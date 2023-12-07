package EmployeeList.Employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor ////
@AllArgsConstructor
public class Employee {
    //Object to store values from json file.
    private int empId;
    private String vardas;
    private String pavarde;
    private double patirtis; //monthly experience
    private double alga; //yearly salary
    private String pareigos;
    private int amzius; //age in years
}
