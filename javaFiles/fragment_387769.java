package test;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test {
    public void printMe() {
        try {
            String classname = Test.class.toString();
            // This gets the full class name, including package
            classname=  classname.replace("class ", "");
            classname= classname.replace(".", "/");
            BufferedReader br = new BufferedReader(new FileReader(<path_to_workspace/project_name/source_folder> + classname + ".java"));

        String line = br.readLine();
        while(line != null) {
            System.out.println(line);
            line=br.readLine();
        }

        } catch (Exception e) {
            e.printStackTrace();
        }       
    }
}