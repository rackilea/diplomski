public static void main(String[] args)
{
    Integer[] arr = new Integer[1];
    arr[0] = 0;

    changeArray(arr);

    System.out.println(arr[0]);

    changeArrayCorrected(arr);

    System.out.println(arr[0]);
}

public static void changeArray(Integer[] arr)
{
    Integer[] anotherArray = new Integer[1];
    anotherArray[0] = 1;
    arr = anotherArray;
}

public static void changeArrayCorrected(Integer[] arr)
{
    arr[0] = 1;
}