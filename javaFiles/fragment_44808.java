import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SoccerRunner {

public static void main(String[] args) throws IOException {

//Path to file location
String pathToFile = "G:\\";

//Data file name & reader
File inFile = new File(pathToFile, "sample.txt");
Scanner inData= new Scanner(inFile);


int someData;
int count=1;
while (inData.hasNext())
{

    someData = inData.nextInt();

    System.out.print(someData + "\t");
    count++;
    if(count==5){
        System.out.print("\n");
        count=1;
    }

}

}

}