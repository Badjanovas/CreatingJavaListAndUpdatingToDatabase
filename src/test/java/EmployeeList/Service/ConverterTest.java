package EmployeeList.Service;

import EmployeeList.Employees.Employee;
import EmployeeList.Employees.EmployeeDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    String filePath = "src/main/resources/EmployeeList.json";
    JsonToJava jsonToJava = new JsonToJava();
    List<Employee> employees = jsonToJava.convertFromJsonToJava(filePath);

    @Test
    public void mustReturnListOfObjectsThatHaveAllSpecificationsReadyForDataBase() {
        Converter converter = new Converter();
        List<EmployeeDTO> employeesDTO = converter.convertEmployeeListToEmployeesDTO(employees);
        assertEquals(100, employeesDTO.size());
        assertEquals(1, employeesDTO.get(0).getID());
        assertEquals("John Doe", employeesDTO.get(0).getFullName());
        assertEquals(3, employeesDTO.get(0).getExperience());
        assertEquals(4166.666666666667, employeesDTO.get(0).getSalary());
        assertEquals("Engineer", employeesDTO.get(0).getJobTitle());
        assertEquals(1993, employeesDTO.get(0).getDob());
    }

}