import java.util.Scanner;

public class StringReadAndWrite {


public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the length of String array");
    int n=sc.nextInt();
    String[] sarray=new String[n];

    for(int i=0;i<n;i++){
        System.out.println("enter the "+(i+1)+" String :");
        sarray[i]=sc.next();
    }
    System.out.println("Strings Entered by user:");

    for(String s:sarray){
        System.out.println(s);
    }

}
}