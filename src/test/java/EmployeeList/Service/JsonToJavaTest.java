package EmployeeList.Service;

import EmployeeList.Employees.Employee;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class JsonToJavaTest {
    String filePath = "src/main/resources/EmployeeList.json";
    JsonToJava jsonToJava = new JsonToJava();
    List<Employee> employees = jsonToJava.convertFromJsonToJava(filePath);

    @Test
    public void mustReturnEmployeeListWith100Objects() {

        assertEquals(100, employees.size());
    }

    @Test
    public void mustReturnFirstObjectsNameJohn() {
        assertEquals("John", employees.get(0).getVardas());
    }

    @Test
    public void mustReturnLastObjectsNameDarian() {
        assertEquals("Darian", employees.get(99).getVardas());
    }

}