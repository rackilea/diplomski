public static String average(Integer[] marks)
{
int sum = 0;
double average;
for (int i = 0; i < marks.size(); i++) 
{
    sum = sum + marks.get(i);
}
average = (double) sum / marks.size();
String averageString = Double.toString(average);
return averageString;
}