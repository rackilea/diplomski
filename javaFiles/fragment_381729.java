int [] num = new int [7];
for (int i = 1000000; i < 9999999; i++)
{
    // put i into the array and check it
    if (checkDigitsDivisible(i, num))
    {
        System.out.println(i);
    }
}