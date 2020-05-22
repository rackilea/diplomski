for (int student = 0 ; student < grades.length ; student ++)
{
System.out.printf ("Student %2d", student + 1);

for ( int test : grades [ student ] ) // output student grades
    System.out.printf ("%8d", test );

// call method getAverage to calculate the student's average grade
// pass row of grades as the argument to getAverage
double average = getAverage (grades [ student ] ) ;
System.out.printf ("%9.2f \r", average );



/*Add this line */ 


       System.out.println ("");



} // end outer for