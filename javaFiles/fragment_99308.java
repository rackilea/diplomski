import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadTemps{

    public static void main(String[] args) throws IOException {
        //taking the word to search from keyboard
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the word you want to search: ");
        String input = keyboard.nextLine();

        //counter for calculating how many times word wrote in line
        int counter = 0;
        //counter to find which line we are searching
        int counterLine = 1;

        // // read KeyWestTemp.txt

        // create token1
        String token1 = "";

        // for-each loop for calculating heat index of May - October

        // create Scanner inFile1
        Scanner inFile1 = new Scanner(new File("C:\\KeyWestTemp.txt"));

        // Original answer used LinkedList, but probably preferable to use
        // ArrayList in most cases
        // List<String> temps = new LinkedList<String>();
        ArrayList<String> temps = new ArrayList<String>();

        // while loop
        while (inFile1.hasNext()) {
            // find next line
            token1 = inFile1.nextLine();
            //removing whitespeaces
            token1.replaceAll("\\s+","");
            //taking all the letters as String
            for(int i = 0; i < token1.length(); i++) {
                char c = token1.charAt(i);
                String s = "" + c;
                temps.add(s);
            }
            //adding a point to find line' end
            temps.add("line");
        }
        inFile1.close();

        String[] tempsArray = temps.toArray(new String[0]);

        //searching on array to find first letter of word
        for (int i = 0; i < tempsArray.length; i++) {
            String s = temps.get(i);
            //if its the end of line time to print
            if(s.equals("line")) {
                System.out.println("Line" + counterLine + " : " + counter + " occurrence ");
                counterLine++;
                counter = 0;
            }
            //if the first letter found need to search rest of the letters
            if(s.equalsIgnoreCase("" + input.charAt(0))) {
                s = "";
                try {
                    for(int j = i; j < i + input.length(); j++) {
                        String comp = temps.get(j);
                        if(comp.equalsIgnoreCase("" + input.charAt(j-i)))
                            s = s + comp;
                    }
                } catch (IndexOutOfBoundsException e) {

                }
                //checks if found the word
                if(s.equalsIgnoreCase(input))
                    counter++;
            }
        }
    }
}