public class Solution
{
  public static int arrayLeftRotation(String str1,
                                      String str2)
  {
    int nr_rotate;
    int counter;
    nr_rotate = 0;
    for (counter = 0; counter < str1.length(); counter++)
    {
      if (str1.equals(str2))
        return (nr_rotate);
      else
      {
        str1 = leftRotateByOne(str1);
        nr_rotate++;
        System.out.println(str1);
      }
    }

    // No possible solution
    return (-1);

  } // arrayLeftRotation

  public static String leftRotateByOne(String str)
  {
    return (str.substring(1) + str.charAt(0));
  }

  public static void main(String[] args)
  {
    String str1 = "david";
    String str2 = "vidda";
    System.out.print(arrayLeftRotation(str1, str2));
  }

} // class Solution