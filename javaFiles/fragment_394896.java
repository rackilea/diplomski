public static void createArithmeticSeq(int [] list)
{   
    int first; 
    int diff;
    //prompt user for first and diff
    System.out.println("Enter first and diff : ");
    first = console.nextInt();
    diff  = console.nextInt();
    //process to create list of n*n elements 
    for (int i=0; i<listSize; i++)
    {
        list[i]=first+i*diff;
    }
}