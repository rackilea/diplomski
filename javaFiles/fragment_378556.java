//write from duplicate array of courses to a CSV file
public static void writeCSV(Course[] courseArray) throws Exception {

    //create a File class object and give the file the name employees.csv
    java.io.File courseCSV = new java.io.File("courses.csv");

    //Create a Printwriter text output stream and link it to the CSV File
    java.io.PrintWriter outfile = new java.io.PrintWriter(courseCSV);

    //Iterate the elements actually being used
    for (int i=0; i < courseArray.length ; i++) {
        outfile.write(courseArray[i].toCSVString());

    }//end for

    outfile.close();
} //end writeCSV()