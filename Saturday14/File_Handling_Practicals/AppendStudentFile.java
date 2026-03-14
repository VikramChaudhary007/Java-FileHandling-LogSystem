package Saturday14.File_Handling_Practicals;

// AppendStudentFile.java
// Program to add new student data to an existing file (students.txt)

import java.io.FileWriter;   // Import FileWriter class for writing data to file
import java.io.IOException;  // Import IOException class for handling file errors

public class AppendStudentFile {

    public static void main(String[] args) {

        try {
            // Create FileWriter object
            // "true" means the file will open in append mode
            // Existing data will not be deleted
            FileWriter writer = new FileWriter("Saturday14/File_Handling_Practicals/students.txt", true);

            // Adding a new line before writing new data
            writer.write("\n");

            // Writing new student details into the file
            writer.write("ID: 102\n");
            writer.write("Name: Priya\n");
            writer.write("Course: BCA\n");
            writer.write("City: Surat\n");

            // Close the file after writing
            writer.close();

            // Message to confirm data was added successfully
            System.out.println("New student data appended successfully.");

        } 
        catch (IOException e) {
            // This block runs if an error occurs while writing the file
            System.out.println("Error occurred while writing to file.");
        }
    }
}
