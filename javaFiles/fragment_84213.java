Hope this will help


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindGivenStringFromFile {

    public static void main(String args[]) throws FileNotFoundException {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a filename >> ");
        String filename = keyboard.nextLine();

        File f = new File(filename);
        Scanner fin = new Scanner(f);

        System.out.println("Enter item ID: ");
        int fruitID = keyboard.nextInt();

        //Reading each line of file using Scanner class
        int lineNumber = 1;
        while (fin.hasNextLine()) {
            String line = fin.nextLine();
            String[] lineDataArray = line.split("\\^");
            if(lineDataArray != null && lineDataArray.length >2){
                if(Integer.parseInt(lineDataArray[1]) == fruitID){
                    System.out.println("Item: " + lineDataArray[0]);
                    System.out.println("Id: " + lineDataArray[1]);
                    System.out.println("price: $" + lineDataArray[2]);
                }

            lineNumber++;
        }       

    }   
}
}