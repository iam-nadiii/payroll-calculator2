package com.pluralsight;

public class Employee {
    public Employee[] employeeList = new Employee[8];
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
            return 40 * hoursWorked + (hoursWorked - 40) * payRate * 0.5;
        }
        return hoursWorked * payRate;
    }




}



//Step 1
//Create an Employee class as described below:
//Private data members (attributes):
//        - employeeId
//- name
//- hoursWorked
//- payRate
//Methods:
//        - parameterized constructor
//- getEmployeeId() and getters/setters for other attributes
//- getGrossPay() that calculates and returns that employee's gross pay based
//on their hours worked and pay rate

//Step 2
//To make the main program work, you will need to:
//        1. Load the file using a FileReader object
//2. Read each line of text
//3. Split it into individual fields using the | character as the delimiter
//4. Copy the values from the tokens array into variables that match the data and then
//use them to create a new Employee object
//5. Display the employee using a printf and by calling the employee's
//getEmployeeId(), getName(), and getGrossPay() methods
//6. Repeat for each line in the input file
//Step 3
//        1. Ensure all your changes are committed and pushed to GitHub
//2. Send your repository URL to your Instructor