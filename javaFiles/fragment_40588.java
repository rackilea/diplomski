public class Four
{
    private double [] numbers = {1.0, 2.0, 3.0, 4.0};

    public double getContents(int index)
    {
       try
       {
          return numbers[index];
       }
       catch(ArrayIndexOutOfBoundsException e)
       {
          return -1.0;
       }
    }
}