public static void main(String[] args)
{
    String inString = "010.011.100.000.111";
    String outString = "";
    String[] arr = inString.split("\\.000\\.");
    outString = arr[0];
    for(int i = 1; i < arr.length; i++)
    {
      outString = outString + arr[i];
    }

    System.out.println(outString);
}