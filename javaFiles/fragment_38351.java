package createcsvfile;

import java.io.*;
import java.io.IOException;

public class CreateCsvFile {
    public static void main(String args[]) throws IOException {

        // Create a 1D array to hold header labels
        String headerLabels[] =  
            {"COURSE ID", "TEAM ID", "STUDENT FIRST NAME",
             "STUDENT LAST NAME", "STUDENT ID", "ASSIGNMENT ID",
             "DATE SUBMITTED", "TIME SUBMITTED", "SUBMITTED BY"
            };

        // Create a 2D array to hold header values
        String headerValues[][] =
            {
            {"CMPS280-02", "Invokers01", "James", "Brown", "w0479045", "H01", "8/25/2017", "1:14PM", "James Brown"},
            {"CMPS280-01", "Winners03", "Jacob", "Harley", "w0389342", "H03", "8/23/2017", "7:24PM", "Jacob Harley"},
            {"SE101-02", "CodeIt00", "Keith", "Dillinger", "w0782345", "S04", "8/25/2017", "1:23AM", "Keith Dillinger"}
            };

        // Array Loop to be used later
        // for (int i = 0; i < headerValues.length; i++){
        // for (int j = 0; j < headerValues[i].length; j++){

        String path1 = "SUBMIT";    
        // Create new .csv file and store in SUBMIT folder
        String path2 = "SUBMIT/"+headerValues[0][0]+"_"+headerValues[0][5]+"_"+headerValues[0][1]+"_"+headerValues[0][4]+".csv";

        try {
            File file1 = new File(path1);
            if (!file1.isDirectory()) {
               file1.mkdir();
            }        
            File file = new File(path2);        
            FileWriter writer = new FileWriter(file);
            writer.close();
        } 
        catch (IOException e) {
            System.out.println("IOException: " + e );
        }
    }
}