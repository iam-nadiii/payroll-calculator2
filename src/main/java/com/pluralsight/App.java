package com.pluralsight;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

import static com.pluralsight.Employee.employeesArray;

public class App {

    static int index = 0;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        readEmployeeInfoFile();

        printEmployeeInfo(employeesArray);


        createEmployeeInfoFile();


    }


    private static void readEmployeeInfoFile() {
        System.out.print("Enter the name of the file employee file to process: ");
        String fileNameToRead = scanner.next();


        String input;


        try{
            FileReader fileReader = new FileReader(fileNameToRead);
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
    }

    private static void createEmployeeInfoFile() {
        System.out.print("Enter the name of the payroll file to create: ");
        String fileNameToWrite = scanner.next();


        try{
            FileWriter fileWriter = new FileWriter(fileNameToWrite);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            if(fileNameToWrite.endsWith(".txt")) {

                bufferedWriter.write("id|name|gross pay\n");

                for (Employee employee : employeesArray) {
                    bufferedWriter.write(employee.getEmployeeId() + "|" + employee.getName() + "|$" +
                            employee.getGrossPay() + "\n");
                }
            } else if(fileNameToWrite.endsWith(".json")){
                bufferedWriter.write("[\n");

                for (Employee employee : employeesArray) {
                    bufferedWriter.write("{\"id\": " + employee.getEmployeeId() + ", \"name\": " +
                            employee.getName() + ", \"grossPay\": $" + employee.getGrossPay() + "}\n");
                }
                bufferedWriter.write("]");

            } else {
                System.out.println("Error: File name has to either end with \"txt\" or \"json\". Please try again");
                createEmployeeInfoFile();
            }


            bufferedWriter.close();

        } catch (IOException e){
            System.out.println("ERROR: An unexpected error occurred");
            e.printStackTrace();
        }
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




//        ]
