import java.util.*;
public class HelloWorld {    
static int btod(int n) {
    int count = 0;
    int mul = 1;
    while(n != 0) {
        int dig = n%10;
        count+= dig * mul;
        n /= 10;
        mul *= 2;

    }
    return count;

}

 public static void main(String []args){
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
    System.out.println("Results: " + HelloWorld.btod(n));

 }
}