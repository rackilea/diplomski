import java.util.Scanner;

public class TestProgram 
{

    public static void main(String[] args) 
    {
        long acctNum = getTheLong();
        searchById(acctNum);
    }

    public static long getTheLong() 
    {
        long acctNum = 0;
        Scanner scano = new Scanner(System.in);
        System.out.println ("enter account number");
        acctNum = scano.nextLong();
        return acctNum;
    }

    public static void searchById(long acctNum) 
    {
        // do something with acctNum
    }
}