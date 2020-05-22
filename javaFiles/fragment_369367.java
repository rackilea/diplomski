public class abc
{
    public static void main (String[] args)
    {
        byte b = -1;
        String binString = Integer.toBinaryString(b); //value 1111,1111,1111,1111,1111,1111,1111,1111
        new BigInteger(binString, 2).byteValue(); //value -1 
    }
}