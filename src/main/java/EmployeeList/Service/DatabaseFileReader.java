package EmployeeList.Service;

import EmployeeList.Employees.EmployeeDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DatabaseFileReader {
    // Class for importing read files to a H2 database

    public void importToDB(List<EmployeeDTO> employeesDTO) {

        final String jdbcUrl = "jdbc:h2:tcp://localhost/~/test";
        final String userName = "sa";
        final String password = "";

        Connection connection = null;
        String insertSql = "INSERT INTO employee_data_base (ID, fullName, experience, salary, jobTitle, dob) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            System.out.println("Connection successful");

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
                for (EmployeeDTO employeeDTO : employeesDTO) {
                    preparedStatement.setInt(1, employeeDTO.getID());
                    preparedStatement.setString(2, employeeDTO.getFullName());
                    preparedStatement.setDouble(3, employeeDTO.getExperience());
                    preparedStatement.setDouble(4, employeeDTO.getSalary());
                    preparedStatement.setString(5, employeeDTO.getJobTitle());
                    preparedStatement.setInt(6, employeeDTO.getDob());

                    preparedStatement.executeUpdate();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
