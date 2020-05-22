public static void main(String[] args)
{
    String math = "123+1+";
    String arrayz[] = { "123", "+", "1", "+" };
    double total = 0.0;

    int i = 0;

    // arrayz.length - 2 -> because you are accessing "arrayz[i + 1]", 
    // arrayz.length - 1 would be OK if the maximum index you were using were "arrayz[i] "
    while (i <= (arrayz.length - 2)) //don't bother with the last char
    {           
        if (arrayz[i].equals("+")) {
            total = Double.parseDouble((String) arrayz[i - 1]) + Double.parseDouble((String) arrayz[i + 1]);
        }
        i++; // Increment at the end of the loop
    }

    System.out.println(total);
}