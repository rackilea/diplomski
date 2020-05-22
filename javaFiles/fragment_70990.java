static void someFunction(String str)
{
   int keyCode = Integer.parseInt(str, 16);
   System.out.println(keyCode); // prints 83
}

public static void main(String[] args)
{
   // passing decimal 83 in hex as a string ("53") to the function
   someFunction(Integer.toHexString(83));
}