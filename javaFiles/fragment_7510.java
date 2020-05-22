public static double average(int[] marks)
{
int sum = 0;
double average;
for(int element: marks)
{
    sum = sum + element;
}
average = (double)sum / marks.length;
return average;
}