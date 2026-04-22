package com.pluralsight;

public class Employee {
    public static Employee[] employeesArray = new Employee[8];
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee(String name, int employeeId, double hoursWorked, double payRate){
        this.name = name;
        this.employeeId = employeeId;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;

    }

    public Employee() {

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getGrossPay(){
        if (hoursWorked > 40){
            return hoursWorked * payRate + (hoursWorked - 40) * payRate * 0.5;
        }
        return hoursWorked * payRate;
    }




}


