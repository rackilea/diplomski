/*
 * TMKRAY 
 * Febuary 18th 2016
 * program for phone plan corrected
 */
import java.util.*;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Feb21716 {
   private static DecimalFormat df2 = new DecimalFormat(".##");
   public static void main(String[] args) {

double total;

System.out.println("Enter your wireless service carrier plan" 
+ "\n Package A: For $29.99 per month 2GB of data is provided. Additional data is $10.00 per GB." 
+ "\n Package B: For $39.99 per month 4GB of data is provided. Additional data is $5.00 per GB. "
+ "\n Package C: For $49.99 per month unlimited data is provided."
+ "\n Please enter only the letter in Upper Case ex. Package A = A");
Scanner sc = new Scanner(System.in);
String whichPackage = sc.nextLine();

System.out.println("Please enter the Amount of data you use in GB" 
+ "\n Please note, just enter the numbers "
+ "\n ex. 750 MB = .75  ");
Scanner dText = new Scanner(System.in);
double packageSize = dText.nextDouble();




if(( whichPackage .equals( "A" ))&&(packageSize <= 2)){
    // when Package is A and less than 2GB
    total = 29.99;
System.out.println("Your Bill is: " +df2.format(total));
} else if(( whichPackage .equals( "A" ))&&(packageSize > 2)) {
    // when package is A and more than 2GB
    total = 29.99 + 10 * (packageSize-2);  
System.out.println("Your Bill is: " + df2.format(total));
} else if(( whichPackage .equals( "B" ))&&(packageSize <= 4)) {
    // when package is B and less than 4GB
    total = 39.99; 
System.out.println("Your Bill is: " + df2.format(total));
} else if(( whichPackage .equals( "B" ))&&(packageSize > 4)){
    // when package is B and more than 4GB
    total = 29.99 + 10 * (packageSize-4);
System.out.println("Your Bill is: " + df2.format(total));
} else if(( whichPackage .equals( "C" ))&&(packageSize < 50)){
    // when package is C and less than 50gb
    total = 49.99;
System.out.println("Your Bill is: " + df2.format(total));
} else if(( whichPackage .equals( "C" ))&&(packageSize > 50)){
    // when package is C and more than 50gb
  total= 0;
System.out.println("You didnt enter a valid number "+total);
}



}
}