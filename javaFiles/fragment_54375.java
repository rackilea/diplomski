public class Test
{
    public static void main(String[] args)
    {
        int[] digits = stringToDig("54235");
    }

    public int[] stringToDig(String a)
    {
        char [] ch1 = a.toCharArray();
        int [] conv = new int [ch1.length];

        for (int i=0 ; i<ch1.length ; i++)
            conv[i] = Character.getNumericValue(ch1[i]);

        return conv; 
    }
}