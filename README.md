
# Append Student File (Java File Handling Practical)


*Overview*
This Java program demonstrates how to append (add) new data to an existing text file.

The program writes new student details into the file:
students.txt

If the file already contains data, the new student information will be added at the end of the file without deleting the existing content.


*Program File*
AppendStudentFile.java


*Concepts Used*
- File Handling in Java
- FileWriter Class
- Append Mode
- Exception Handling
- Try-Catch Block


*How the Program Works*

1. The program creates a FileWriter object.
2. The FileWriter is opened in append mode using:
   true
3. The program writes new student data into students.txt.
4. The file is closed after writing.
5. A confirmation message is printed on the console.


*File Location*

The program writes data to:

Saturday14/File_Handling_Practicals/students.txt


*Example Student Data Added*

ID: 102
Name: Priya
Course: BCA
City: Surat


*Example Output*

New student data appended successfully.


*Learning Outcome*

This practical helps to understand:
- How to write data to a file
- How to append data without deleting existing data
- Basic file handling operations in Java


-------------------------------------------------------------------------------------------------------------------------------------------

# CSV File Reader (Java File Handling Practical)


*Overview*
This Java program demonstrates how to read data from a CSV (Comma Separated Values) file.

The program reads the file:
students.csv

and prints all records line by line on the console.


*Program File*
CSVFileReader.java


*Concepts Used*
- File Handling in Java
- FileReader Class
- BufferedReader Class
- Reading files line by line
- Exception Handling (Try-Catch)


*How the Program Works*

1. The program opens the file students.csv using FileReader.
2. BufferedReader is used to read the file efficiently.
3. The program reads the file line by line using readLine().
4. Each line (record) from the CSV file is printed on the console.
5. After reading all records, the file is closed.


*File Location*

The CSV file should be placed at:

Saturday14/File_Handling_Practicals/students.csv


*Example CSV File (students.csv)*

ID,Name,Course,City
101,Rahul,BCA,Ahmedabad
102,Priya,BCA,Surat
103,Amit,BCA,Vadodara
104,Neha,BCA,Rajkot


*Learning Outcome*

This practical helps to understand:

- How to read a CSV file in Java
- How to process file data line by line
- Basic file handling operations
- Handling errors using try-catch


-------------------------------------------------------------------------------------------------------------------------------------------

# Employee Log System (Java Mini Project)


*Overview*
This is a simple Java mini project that manages employee records and logs all actions.

The program allows users to add, delete, update, search, and view employees.
All actions are recorded in a log file (app.log) with date and time.

Employee data is also stored in a file so that it is saved even after the program closes.


*Features*
- Add Employee
- Delete Employee
- Update Employee
- Search Employee
- View Employee List
- Employee Count
- Save employees to file
- Load employees when program starts
- Logging system with timestamp


*Technologies Used*
- Core Java
- ArrayList
- File Handling
- Exception Handling
- Scanner (User Input)


*Project Structure*

Project_TY
│
└── Saturday14
    │
    └── Log_System_Mini_Project
        │
        ├── EmployeeLogSystem.java
        ├── employees.txt
        └── app.log


*How the Program Works*

1. The program starts and loads employees from employees.txt.
2. A menu is displayed to the user.
3. The user can perform different actions:
   - Add employee
   - Delete employee
   - Search employee
   - Update employee
4. Every action is saved in app.log with date and time.
5. When the program exits, employees are saved to employees.txt.


*Example Menu*

===== Employee Management System =====

1 Add Employee
2 Delete Employee
3 Update Employee
4 Search Employee
5 View Employees
6 Employee Count
7 Exit


*Example Log File*

2026-03-14 12:45:01 - Application started
2026-03-14 12:45:10 - Employee added: Rahul
2026-03-14 12:45:20 - Viewed employee list
2026-03-14 12:45:40 - Employees saved to file
2026-03-14 12:45:41 - Application closed


*Learning Concepts*

This project helps to understand:
- Java File Handling
- Logging System
- ArrayList
- Menu Driven Programs
- Exception Handling
- Basic Project Structure
