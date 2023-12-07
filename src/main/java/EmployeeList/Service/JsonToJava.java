package EmployeeList.Service;

import EmployeeList.Employees.Employee;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonToJava {
    //Method for converting json file using Gson framework.
    public List<Employee> convertFromJsonToJava(final String filePath) {
        Gson gson = new Gson();
        Type employeeListType = new TypeToken<List<Employee>>() {
        }.getType();

        List<Employee> employeesFromFile;

        try {
            Reader reader = new FileReader(filePath);
            employeesFromFile = gson.fromJson(reader, employeeListType);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return employeesFromFile;
    }

}
