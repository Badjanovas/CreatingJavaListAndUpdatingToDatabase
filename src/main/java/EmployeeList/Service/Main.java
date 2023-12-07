package EmployeeList.Service;

import EmployeeList.Employees.Employee;
import EmployeeList.Employees.EmployeeDTO;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String filePath = "src/main/resources/EmployeeList.json";
        JsonToJava jsonToJava = new JsonToJava();
        Converter converter = new Converter();
        DatabaseFileReader databaseFileReader = new DatabaseFileReader();

        List<Employee> employees = jsonToJava.convertFromJsonToJava(filePath);
        List<EmployeeDTO> employeeDTOS = converter.convertEmployeeListToEmployeesDTO(employees);
        databaseFileReader.importToDB(employeeDTOS);

    }
}
