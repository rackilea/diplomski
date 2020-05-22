import java.io.*;

public class test
{
     public static void main(String[] args) {

        String input="7 to 10";//pass any input here that contains delimeter "to"
        String[] ans=input.split("to");

        for(String result:ans) {
        System.out.println(result.trim());
        }
    }
}