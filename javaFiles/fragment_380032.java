public static void main(String[] args)
{
    int startValue = 1;
    int numberOfAdditions = 10;
    int currentValue = startValue;
    for(int i = 0;i<numberOfAdditions;i++)
    {
        //do opperations here
         currentValue = currentValue+currentValue;
        //print out value
         System.out.println(currentValue);
    }
}