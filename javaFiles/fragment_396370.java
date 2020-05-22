import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Baseball {

    private File textFile;
    private Scanner input;
    private String teamName;

    //this will only work if you know there will be 20 entries everytime
    //otherwise I recommend loading the data into an ArrayList
    private double []battingAvgs = new double[20];

    public Baseball(String file){
        textFile = new File(file);
        readInFile(textFile);

    }

    //private method that reads in the file into an array 
    private void readInFile(File textFile){
        try {
            input = new Scanner(textFile);

            //read first string into variable teamName
            teamName = input.next();

            int i=0;
            //iterate through rest of file adding it to an ArrayList
            while(input.hasNext()){
                battingAvgs[i] = input.nextDouble();
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //print out array
    public void printArray(){
        for(Double a: battingAvgs){
            System.out.println(a);
        }
    }

}