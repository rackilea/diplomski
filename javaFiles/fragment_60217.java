public static void main (String [] args)
{
    int [] data = { 1, 2, 1, 5, 2, 3, 1 };
    int [] ret = answer(data, 2);

    // no 1s will be present in the output
    System.out.println(Arrays.toString(ret));
}