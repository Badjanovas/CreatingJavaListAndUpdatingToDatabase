package EmployeeList.Employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    //object to store values from java to database, different values.
    private int ID;
    private String fullName;
    private double experience; //experience in years
    private double salary; //monthly salary
    private String jobTitle;
    private int dob; //year of birth
}
