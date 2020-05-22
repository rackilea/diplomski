public static boolean checkDigitsDivisible (int num, int [] arr)
{
    int one = num / 1000000;
    int two = num / 100000;
    int three = num / 10000;
    int four = num / 1000;
    int five = num / 100;
    int six = num / 10;
    int seven = num;

    arr[0] = one % 10;
    arr[1] = two % 10;
    arr[2] = three % 10;
    arr[3] = four % 10;
    arr[4] = five % 10;
    arr[5] = six % 10;
    arr[6] = seven % 10;

    return (one % 1 == 0) && 
           (two % 2 == 0) && 
           (three % 3 == 0) && 
           (four % 4 == 0) && 
           (five % 5 == 0) && 
           (six % 6 == 0) &&
           (isDivisibleBy7(seven));
}