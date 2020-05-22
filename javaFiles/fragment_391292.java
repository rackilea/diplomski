double array[] = new double[size];
int index = 0;
while (thereAreStillNumbersInTheInput())
{
    double d = readDoubleFromInput();
    array[index++] = d;
}