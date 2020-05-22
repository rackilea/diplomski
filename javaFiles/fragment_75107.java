import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {

    private ArrayList<String[]> allNames;

    public static void main(String[] args) throws IOException {

        Test t = new Test();
        t.go();
    }

    public void go() {

        try {
            this.getNames();
            this.printAll();
            this.printFirstNamesCount();
        }
        catch(IOException ioEx) {

            System.out.println("Input file error. Info : " + ioEx.getMessage());
        }
    }

    private void getNames() throws IOException {

        allNames = new ArrayList<String[]>();
        Scanner kb = new Scanner(System.in);
        System.out.print("What is the name input file? ");
        String fileName = kb.next();
        File inpFile = new File(fileName);
        Scanner in = new Scanner(inpFile);

        while (in.hasNext()) {

            //slot the string into a arry (last name, first name)
            //use nextLine() or it won't read beyond spaces
            String[] tmp = in.nextLine().split(",");
            //remove white spaces in the first name
            tmp[1] = tmp[1].replaceAll("\\s+","");
            //capitalize both first and last names
            tmp[0] = capitalize(tmp[0]);
            tmp[1] = capitalize(tmp[1]);
            allNames.add(tmp);
        }
    }

    private void printAll() {

        System.out.println("******* All Names *********");

        for(String[] tmp : allNames) {

            //array index 1 is they first name and 0 is the last name
            System.out.println(tmp[1] + " " + tmp[0]);
        }
    }

    private void printFirstNamesCount() {

        HashMap<String, Integer> firstNamesCount = new HashMap<String, Integer>();

        for(String[] tmp : allNames) {

            //we haven't counted this first name yet
            if(firstNamesCount.get(tmp[1]) == null) {

                firstNamesCount.put(tmp[1], 1);
            }
            //we have counted this name, so let's just increment it
            else {

                firstNamesCount.put(tmp[1], (firstNamesCount.get(tmp[1]) + 1));
            }
        }

        //now let's print the hash map

        System.out.println("******* First Names Count *********");

        for(Map.Entry<String, Integer> e : firstNamesCount.entrySet()) {

            System.out.println(e.getKey() + " - " + e.getValue());
        }
    }

    //capitalize the first letter
    private String capitalize(String line) {

        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }
}