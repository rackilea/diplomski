import java.io.*;

public class Solution {

    public static int staircase(int m){
        return (int) Math.floor((Math.sqrt(8*(double)m+1)-1)/2);
    }

    public static void main(String[] args){
        System.out.println("Result:"+staircase(16));
    }
}