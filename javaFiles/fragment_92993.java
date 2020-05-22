while (index < array.length && x >= 0)
{
    System.out.print("Sample " + (index+1) + ": ");
    x = scan.nextDouble();
    count++;
    if (x < 0) 
    {
        count--;
    }
    else
    {
        array[index] = x;
        index++;
    }
}