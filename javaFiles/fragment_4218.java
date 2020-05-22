import java.util.Scanner;
import java.text.DecimalFormat;

public class Homework8{

static double average;
static char grade;
public static void main (String[] args)  {    
Scanner keyboard = new Scanner(System.in);
char letter1;
char letter2;
char letter3;
char letter4;
char letter5;
double score1;
double score2;
double score3;
double score4;
double score5;
double score;    

System.out.println("Please enter the first score between 0 and 100: "); 
score1 = keyboard.nextDouble();


System.out.println("Please enter the second score between 0 and 100:             "); 
score2 = keyboard.nextDouble(); 


System.out.println("Please enter the third score between 0 and 100: "); 
score3 = keyboard.nextDouble(); 


System.out.println("Please enter the fourth score between 0 and 100: "); 
score4 = keyboard.nextDouble(); 


System.out.println("Please enter the fifth score between 0 and 100: "); 
score5 = keyboard.nextDouble(); 

double average = calcAverage(score1,score2,score3,score4,score5);
//System.out.println("The average of your five tests was: " + 


System.out.println( 
  "For TestA you scored: " + score1 + " giving you Grade: " 
      + determineGrade(score1) 
  + "\nFor TestB you scored: " + score2 + " giving you Grade: " 
      + determineGrade(score2) 
  + "\nFor TestC you scored: " + score3 + " giving you Grade: " 
      + determineGrade(score3) 
  + "\nFor TestD you scored: " + score4 + " giving you Grade: " 
      + determineGrade(score4) 
  + "\nFor TestF you scored: " + score5 + " giving you Grade: " 
      + determineGrade(score5) 
  + "\nBased on your average: " + average + " Your final Grade is: " 
      + determineGrade((double)average));
  }

 public static double calcAverage(double score1, double score2, double     score3, double score4, double score5) {
 double average = (score1+score2+score3+score4+score5) / 5.0;
 return average;

}
public static char determineGrade(double score)
{

   if(score<=100 && score>=90)
   {
   return 'A';
   }

   else if(score>=80)
   {
   return 'B';
   }      
   else if(score>=70)
   {
   return 'C';
   }       
   else if(score>=60)
   {
   return 'D';
   }

   else
   {
   return 'F';
   }  

}
}