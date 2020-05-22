public class Test
{
    public static void main(String[] args) 
    {
        int[] digits = getDigits(123);
        for (int digit : digits)
        {
            System.out.print(digit); // Prints 00123
        }
    }

    public static int[] getDigits(int value)
    {
        int[] ret = new int[5];
        for (int i = 4; i >=0 ; i--)
        {
            ret[i] = value % 10;
            value = value / 10;
        }
        return ret;
    }
}