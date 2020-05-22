import java.util.Scanner;

public class test1{

        static Scanner scan = new Scanner(System.in);
        static int k;

        public static void main(String[] args) {
            setK();
            System.out.println(" K is: " + k);
    }
        public static void setK(){
            System.out.println("Please input K value");
            k = scan.nextInt();
    }
}