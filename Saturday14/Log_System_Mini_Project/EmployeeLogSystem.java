package Saturday14.Log_System_Mini_Project;

// EmployeeLogSystem.java
// Mini Project: Employee Management System with Logging and File Storage

import java.io.*;                     // For file handling
import java.time.LocalDateTime;      // For current date and time
import java.time.format.DateTimeFormatter; // For formatting date and time
import java.util.ArrayList;          // To store employee names
import java.util.Scanner;            // For user input

public class EmployeeLogSystem {

    // ArrayList to store employee names in memory
    static ArrayList<String> employees = new ArrayList<>();

    // File paths where data and logs will be stored
    static String employeeFile = "Saturday14/Log_System_Mini_Project/employees.txt";
    static String logFile = "Saturday14/Log_System_Mini_Project/app.log";


    // ---------------------------------------------------------
    // Method: writeLog()
    // Purpose: Write actions into log file with date and time
    // ---------------------------------------------------------
    public static void writeLog(String message) {

        try {

            // Format for date and time
            DateTimeFormatter format =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // Get current time
            String time = LocalDateTime.now().format(format);

            // Open log file in append mode (true = add new line without deleting old logs)
            FileWriter writer = new FileWriter(logFile, true);

            // Write time + message into log file
            writer.write(time + " - " + message + "\n");

            // Close file
            writer.close();

        } catch (IOException e) {

            // Error handling if file writing fails
            System.out.println("Error writing log.");

        }
    }


    // ---------------------------------------------------------
    // Method: loadEmployees()
    // Purpose: Load employee names from employees.txt when program starts
    // ---------------------------------------------------------
    static void loadEmployees() {

        try {

            // Open file for reading
            BufferedReader reader =
                    new BufferedReader(new FileReader(employeeFile));

            String line;

            // Read each line from file and add to ArrayList
            while ((line = reader.readLine()) != null) {

                employees.add(line);

            }

            // Close file after reading
            reader.close();

            writeLog("Employees loaded from file");

        } catch (IOException e) {

            // If file not found, start program with empty list
            System.out.println("No employee file found. Starting fresh.");

        }
    }


    // ---------------------------------------------------------
    // Method: saveEmployees()
    // Purpose: Save employee list to employees.txt before program exits
    // ---------------------------------------------------------
    static void saveEmployees() {

        try {

            // Create FileWriter to overwrite file with latest data
            FileWriter writer = new FileWriter(employeeFile);

            // Write each employee name to file
            for (String emp : employees) {

                writer.write(emp + "\n");

            }

            // Close file
            writer.close();

            writeLog("Employees saved to file");

        } catch (IOException e) {

            System.out.println("Error saving employees.");

        }
    }


    // ---------------------------------------------------------
    // Method: addEmployee()
    // Purpose: Add new employee to the list
    // ---------------------------------------------------------
    static void addEmployee(String name) {

        employees.add(name);  // Add employee to ArrayList

        System.out.println("Employee added: " + name);

        writeLog("Employee added: " + name);
    }


    // ---------------------------------------------------------
    // Method: deleteEmployee()
    // Purpose: Remove employee from list
    // ---------------------------------------------------------
    static void deleteEmployee(String name) {

        // remove() returns true if employee exists
        if (employees.remove(name)) {

            System.out.println("Employee deleted: " + name);

            writeLog("Employee deleted: " + name);

        } else {

            System.out.println("Employee not found.");

            writeLog("Delete failed: " + name);

        }
    }


    // ---------------------------------------------------------
    // Method: updateEmployee()
    // Purpose: Change employee name
    // ---------------------------------------------------------
    static void updateEmployee(String oldName, String newName) {

        // Find index of old name
        int index = employees.indexOf(oldName);

        if (index != -1) {

            // Replace old name with new name
            employees.set(index, newName);

            System.out.println("Employee updated.");

            writeLog("Employee updated: " + oldName + " -> " + newName);

        } else {

            System.out.println("Employee not found.");

        }
    }


    // ---------------------------------------------------------
    // Method: searchEmployee()
    // Purpose: Check if employee exists in list
    // ---------------------------------------------------------
    static void searchEmployee(String name) {

        if (employees.contains(name)) {

            System.out.println("Employee found: " + name);

            writeLog("Employee searched: " + name);

        } else {

            System.out.println("Employee not found.");

        }
    }


    // ---------------------------------------------------------
    // Method: viewEmployees()
    // Purpose: Display all employees
    // ---------------------------------------------------------
    static void viewEmployees() {

        System.out.println("\n------ Employee List ------");

        // Check if list is empty
        if (employees.isEmpty()) {

            System.out.println("No employees available.");

        } else {

            int i = 1;

            // Print employees with numbering
            for (String emp : employees) {

                System.out.println(i + ". " + emp);

                i++;

            }

        }

        System.out.println("---------------------------");

        writeLog("Viewed employee list");
    }


    // ---------------------------------------------------------
    // Method: employeeCount()
    // Purpose: Show total number of employees
    // ---------------------------------------------------------
    static void employeeCount() {

        System.out.println("Total Employees: " + employees.size());

        writeLog("Checked employee count");
    }


    // ---------------------------------------------------------
    // Main Method - Program Entry Point
    // ---------------------------------------------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Load employees from file at program start
        loadEmployees();

        writeLog("Application started");


        // Infinite loop for menu-driven program
        while (true) {

            System.out.println("\n===== Employee Management System =====");

            System.out.println("1 Add Employee");

            System.out.println("2 Delete Employee");

            System.out.println("3 Update Employee");

            System.out.println("4 Search Employee");

            System.out.println("5 View Employees");

            System.out.println("6 Employee Count");

            System.out.println("7 Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            sc.nextLine(); // clear buffer


            switch (choice) {

                case 1:

                    System.out.print("Enter employee name: ");

                    String name = sc.nextLine();

                    addEmployee(name);

                    break;


                case 2:

                    System.out.print("Enter employee name to delete: ");

                    name = sc.nextLine();

                    deleteEmployee(name);

                    break;


                case 3:

                    System.out.print("Enter old employee name: ");

                    String oldName = sc.nextLine();

                    System.out.print("Enter new employee name: ");

                    String newName = sc.nextLine();

                    updateEmployee(oldName, newName);

                    break;


                case 4:

                    System.out.print("Enter employee name to search: ");

                    name = sc.nextLine();

                    searchEmployee(name);

                    break;


                case 5:

                    viewEmployees();

                    break;


                case 6:

                    employeeCount();

                    break;


                case 7:

                    // Save employee list before closing program
                    saveEmployees();

                    writeLog("Application closed");

                    System.out.println("Program ended.");

                    sc.close();

                    return;


                default:

                    System.out.println("Invalid choice.");

            }
        }
    }
}