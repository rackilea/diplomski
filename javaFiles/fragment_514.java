public class ExamsFor4 {

public static void main(String[] arguments) {


int inputNumber; // One of the exams input by the user.
int sum = 0;     // The sum of the exams.
int i;       // Number of exams.
Double Avg;      // The average of the exams.

TextIO.put("Please enter the first exam: ");        // get the first exam.
inputNumber = TextIO.getlnInt();    

for ( i = 1; i < 4; i++ ) {  

    sum += inputNumber;                 // Add inputNumber to running sum.
    TextIO.put("Please enter the next exam: ");     // get the next exam.   
    inputNumber = TextIO.getlnInt();
} 

Avg = ((double)sum) / i;
TextIO.putln();
TextIO.putln("The total sum for all " + i +" exams is " + sum);
TextIO.putf("The average for the exams entered is %1.2f.\n", Avg);
break;

}   // end main ()
}