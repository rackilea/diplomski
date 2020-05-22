import java.io.*;
import java.util.*;

public class loops {
public static void main (String [] args) throws FileNotFoundException{

    File myFile = new File("Snowboard_Scores.txt");
    Scanner input = new Scanner(myFile);

    String name = "";
    String country = "";
    double score = 0.0;

    while (input.hasNext() ){
        String tmp_name = input.nextLine();
        String tmp_country = input.nextLine();
        double tmp = Double.parseDouble(input.nextLine())/3;
        tmp += Double.parseDouble(input.nextLine())/3;
        tmp += Double.parseDouble(input.nextLine())/3;
        if(tmp > score){
            name = tmp_name;
            country = tmp_county;
            score = tmp;
        }
    }
    System.out.println(name);
    System.out.println(country);
}