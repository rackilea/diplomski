import java.io.*;

import java.util.*;

public class Main {

public static int median(int[] arr)

{

    return arr[arr.length/2];
}

public static int med(int[] arr)
{
    return arr.length/2;
}

public static  int max(int x, int y)
{
    if (x>y)
        return x;
    else
        return y;
}

public static int min(int x, int y)
{
    if (x<y)
        return x;
    else
        return y;
}

public static int compute_median(int[] arr1, int[] arr2)
{
    //arr1 and arr2 are either length 1 or 2 in this function
    return (max(arr1[0], arr2[0]) + min(arr1[arr1.length-1], arr2[arr2.length-1])) / 2;
}

public static int medianOfBoth(int[] arr1, int[] arr2)
{
    if (arr1.length <= 2 && arr2.length <= 2)
    {
        return compute_median(arr1, arr2);
    }

    else if (median(arr1) > median(arr2))
    {
        //erase top half of arr1 and bottom half of arr2
        //System.out.println("hi ="+med(arr2)+" "+arr2.length+"\n");
        arr1 = Arrays.copyOfRange(arr1, 0, med(arr1));
        arr2 = Arrays.copyOfRange(arr2, med(arr2), arr2.length);
        return medianOfBoth(arr1, arr2);
    }

    else // if (median(arr1) < median(arr2))
    {
        //System.out.println("bi ="+med(arr1)+" "+arr1.length+"\n");
        arr1 = Arrays.copyOfRange(arr1, med(arr1), arr1.length);
        arr2 = Arrays.copyOfRange(arr2, 0, med(arr2));
        return medianOfBoth(arr1,arr2);
    }
}

public static void main(String[] args)
{
    int[] arr1 = new int[]{1,2,3,4,5};
    int[] arr2 = new int[]{1,3,5,7,9};
    System.out.println(medianOfBoth(arr1, arr2));
}
}