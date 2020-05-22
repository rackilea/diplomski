package com.example.removespaces

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class RemoveSpacesInFileEx {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        FileReader fr = new FileReader("input.txt"); 
        BufferedReader br = new BufferedReader(fr); 
        FileWriter fw = new FileWriter("outfile.txt"); 
        String line;

        while((line = br.readLine()) != null)
        { 
            line = line.trim();
            line=line.replaceAll("\\s+", " ");
            fw.write(line);


        }
        fr.close();
        fw.close();
    }

}