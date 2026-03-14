package Saturday14.File_Handling_Practicals;

// CSVFileReader.java
// Program to read data from students.csv file and print all records

import java.io.BufferedReader;   // Used to read text from a file efficiently
import java.io.FileReader;       // Used to open the file for reading
import java.io.IOException;      // Used for handling file reading errors

public class CSVFileReader {

    public static void main(String[] args) {

        String line; // Variable to store each line from the CSV file

        try {
            // Create FileReader object to open students.csv
            FileReader file = new FileReader("Saturday14/File_Handling_Practicals/students.csv");

            // BufferedReader reads the file line by line
            BufferedReader reader = new BufferedReader(file);

            // Read each line until the end of file
            while ((line = reader.readLine()) != null) {

                // Print the line (record) on the console
                System.out.println(line);
            }

            // Close the reader after reading the file
            reader.close();
        } 
        catch (IOException e) {
            // If any error occurs while reading the file
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}