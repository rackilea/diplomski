import java.util.Scanner;

public class MainClass {

public static void main(String[] args) {

int[] zeeslag = new int[5];
int total = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
// Make our input / output object
Scanner sc = new Scanner(System.in);

for(int i = 0; i <5; ++i)
{
    System.out.println("Enter number " + (i+1) + " of " + 5 + ":" );
    zeeslag[i] = sc.nextInt();
    total += zeeslag[i]; // total and average
    if(zeeslag[i] < min)
        min = zeeslag[i];
    if(zeeslag[i] > max)
        max = zeeslag[i];
}

System.out.println("total: " + total);
System.out.println("Average: " + (total/5));
System.out.println("Lowest: " + min);
System.out.println("Greatest: " + max);
}
}