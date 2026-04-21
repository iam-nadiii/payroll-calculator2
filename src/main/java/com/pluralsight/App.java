package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {

    static int index = 0;
    public static void main(String[] args) {
        String input;
        Employee[] employeesArray = new Employee[8];

        try{
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean firstLine = true;
            while( (input = bufferedReader.readLine()) != null) {
                if (firstLine == true){
                    firstLine = false;
                    continue;
                }
                createEmployee(input, employeesArray);

            }


            bufferedReader.close();


        } catch (IOException e){
            e.printStackTrace();
        }

        printEmployeeInfo(employeesArray);

    }

    private static void printEmployeeInfo(Employee[] employeesArray) {
        for(Employee employee: employeesArray){
            System.out.println("[Name: " + employee.getName() + ", ID: " + employee.getEmployeeId() + ", Number of" +
                    "hours worked: " + employee.getHoursWorked() + ", Hourly Pay: $" + employee.getPayRate()
            + ", Gross Pay: $" + employee.getGrossPay() + "]");
        }
    }

    private static void createEmployee(String input, Employee[] employeesArray) {
        String[] objects = input.split("\\|");
        Employee currentEmployee = new Employee();
        currentEmployee.setEmployeeId(Integer.parseInt(objects[0].trim()));
        currentEmployee.setName(objects[1].trim());
        currentEmployee.setHoursWorked(Double.parseDouble(objects[2].trim()));
        currentEmployee.setPayRate(Double.parseDouble(objects[3].trim()));

        employeesArray[index] = currentEmployee;
        index++;
    }
}
