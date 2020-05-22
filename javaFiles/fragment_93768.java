import java.util.*;
import java.util.stream.*;

public class HelloWorld {

     public static void main(String[] args){

        String line = "Test 15 lqlq 35 bad 99999 guess 34";

        int sum = Arrays
            .stream(line.split(" ")) // Convert to an array
            .filter((s) -> s.matches("\\d+"))  // Only select the numbers
            .mapToInt(Integer::parseInt)  // Convert to Integers
            .sum(); // Sum

        System.out.println(sum);
     }
}