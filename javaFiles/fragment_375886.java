package com.stackoverflow;

import com.google.common.base.Strings;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.logging.Logger;

public class StackOverflow_56719783 {

    public static void main(String[] args) throws Exception{
        final Logger logger = Logger.getLogger(StackOverflow_56719783.class.getSimpleName());

        //Use the port.getInputStream() instead of the file. I used file as you had given access to the
        //file in google drive present in the local machine.
        File inputFile = new File("XXXXX/inputfile.txt");
        //The FileInputStream is used in place of port.getInputStream() here.
        Scanner scan = new Scanner(new FileInputStream(inputFile));
        String serialData;
        //Use scan.hasNext() instead of scan.hasNextLine(). Please check the JavaDocs for
        //both these methods for the reason.
        while(scan.hasNext()) {
            serialData = scan.next();
            //Check if the current line is an empty line - Strings class is from google's guava library
            //https://github.com/google/guava/wiki/Release21
            if(Strings.isNullOrEmpty(serialData)) {
                continue;
            }

            //If current string does not contain the delimiter at all, we continue.
            if(!serialData.contains(",")) {
                logger.info("The input line does not contain the de-limiter ,");
                continue;
            }
            //Now we continue to split
            String[] dataValues = serialData.split(",");
            //If should be true that the length of the split array is greater than 0 and equal to 3.
            //Going by your input values, the first value looks like to be always an integer, second value is a double, third value is also a double.
            if(dataValues.length > 0 && dataValues.length == 3) {
                int millis = Integer.parseInt(dataValues[0]);
                double sensor1 = Double.parseDouble(dataValues[1]);
                double sensor2 = Double.parseDouble(dataValues[2]);
                System.out.println(millis + " "+ sensor1 + " "+sensor2);
            }
        }
        scan.close();
    }
}