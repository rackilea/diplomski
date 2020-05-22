import java.util.Scanner;

public class PrimeNumbers{ public static void main(String[] agrs){

int max;
int numPrinted=0;
Scanner sk = new Scanner(System.in);
System.out.print("How many prime numbers you want to display? ");
max = sk.nextInt();

System.out.print("Prime numbers: ");

for(int x =2; numPrinted < max; x++){
    boolean isPrime = true;
    for(int y = 2; y < x; y++){
        if(x % y == 0){     
            isPrime = false;
            break; 
    }
    }if (isPrime){
        System.out.print(x + " "); 
        numPrinted++; 
}

} System.out.print("...");

} }