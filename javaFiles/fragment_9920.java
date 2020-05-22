import java.util.Scanner;                  //call up classes to be used in the program
import java.util.Random;

public class TermProject {

 public static void main(String[] args) {

   int n;                     //designate variables
   int randomNumMin;
   int randomNumMax;
   int iteration;
   int swap;

   Scanner scan = new Scanner(System.in);          //create scanner

   System.out.print("How many numbers should be in the array? ");      //get input from user to designate the size of the array to be used
   n = scan.nextInt();                                                   //this method allows for ease of use when changing the parameters of the program

   System.out.print("What should the minimum value for the array be? "); //user input, same reasoning, ease of use when changing parameters
   randomNumMin = scan.nextInt();

   System.out.print("What about the maximum value? ");
   randomNumMax = scan.nextInt();

   System.out.print("How many times do you want to run the program? ");  //user input to designate how many times the program should execute
   iteration = scan.nextInt();

   int[] ar = new int[n];    //create new array

   Random random = new Random();  //create foundation for random number generation

   long startTime; 
   double[] eTime = new double[iteration]; // array used to store execution times

    for (int r = 0; r < iteration; r++) {   //tell program to start iterations here and run repitions
       System.out.println();                 //up to the corresponding parse
       System.out.println("\n");
       System.out.println(r + 1 + ". " + "The program will sort this array: ");    //a label for the unsorted array

       startTime = System.nanoTime(); //store the current time when starting the loop

       for (int i = 0; i < n; i++) {
           ar[i] = random.nextInt(ar.length);    //populate unsorted array with randomly generated numbers

           System.out.print("   " + ar[i] + ", ");    //print out the randomly generated array
       }

       for (int i = 0; i < (n - 1); i++) {           //sort the previously generated array
           for (int d = 0; d < n - i - 1; d++) {     //bubblesort method
               if (ar[d] > ar[d + 1]) {
                   swap = ar[d];
                   ar[d] = ar[d + 1];
                   ar[d + 1] = swap;
               }
           }
       }
       System.out.println("\n");          //print out a label for the sorted array
       System.out.println();
       System.out.println("   After Bubblesorting the array becomes: ");

       for (int i = 0; i < n; i++) //populate the array with sorted information and print out
       {
           System.out.print("   " + ar[i] + ", ");
       }        

       eTime[r] = (System.nanoTime() - startTime)/1e9; //storing the time in the array
       System.out.println();
       System.out.println("\n" + eTime[r] +" Seconds");
   }

   // just printing out the sorting times **************
   System.out.println();
   int itNo = 1;
   for(Double d: eTime)
   {
       System.out.println("Iteration " + itNo + " time is:" + d);
       itNo++; 
   }   

   //Averaging the times **************************
   System.out.println();
   double average = 0.0;
   for(double d: eTime)
   {
       average += d;
   }

   average /= eTime.length; //storing the average in the average variable.

   System.out.println("The average execution time is:" + average + "."); 

 }

}