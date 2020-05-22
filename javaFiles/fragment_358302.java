public class Allocaty
{
  public static void main(String[] args)
  {
    long[] array = new long[Integer.MAX_VALUE];
    long value = 1L;
    for(int ii=Integer.MAX_VALUE; ii>=0; ii--)
    {
      array[ii] = value++;
    }
    String str = Arrays.toString(array);
    System.out.printf("%d: %s", array.length, str);
  }
}