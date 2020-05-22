import java.util.Scanner;
 public class ScanInteger {
    public static void main(String...args)throws Throwable {
        int num = 0; String s= null;
        System.out.print("Please enter a number : ");
        Scanner sc = new Scanner(System.in);
        do{
        try{    
                s = sc.next();
                num= Integer.parseInt(s);
                System.out.println("You have entered:  "+num+" enter again : ");
        }catch(NumberFormatException e){
            if(!s.equalsIgnoreCase("q"))
                System.out.println("Please enter q to quit else try again ==> ");
            }
        }while(!s.equalsIgnoreCase("q"));
    sc.close();
    }
}