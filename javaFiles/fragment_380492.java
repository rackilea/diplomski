System.out.print("Final Grade (needs to be between 0-100): "); // remove this
double finalGrade = numberReader.nextDouble(); // remove this
do
{
   System.out.print("Final Grade (needs to be between 0-100): ");
   finalGrade = numberReader.nextDouble();
}
while ((finalGrade < 0) || (finalGrade > 100));