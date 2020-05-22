import java.io.*;
import java.util.*;

public class Lab8
{
public static void main(String args[]) throws Exception
{
    BufferedReader infile = new BufferedReader(new FileReader(args[0]));
    HashMap<String,Integer> histogram = new HashMap<String,Integer>();
    String word;
    while ((infile.ready()))
    {
        word = infile.readLine();
        if(histogram.get(word)== null) //if the word your currently on is not duplicated
        {
            histogram.put(word,1);
        }
        else
        {
            histogram.put(word, histogram.get(word)+1);
        }
    }   
             // YOUR CODE HERE

    infile.close();
    printHistogram( histogram );

} // END MAIN
// YOU FILL IN THIS METHOD
// READ PROBLEM SPECIFICATION TO SEE WHAT IS THE 80% vs 100% CREDIT SOLUTION

private static void printHistogram( HashMap<String,Integer> hm )
{
    List <String> keys = new ArrayList<String> (hm.keySet());   
    Collections.sort(keys);
    for (String key: keys) 
    {
        System.out.println(key + "\t"  + hm.get(key));

    }
} 
}// END LAB8 CLASS