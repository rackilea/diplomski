int[][] original = {
    {1,2,3},
    {4,5,6}
};

int[][] copy = new int[1][];
copy[0] = original[0];

System.out.println(original[0]);
System.out.println(copy[0]);

System.out.println(Arrays.toString(original[0]));
System.out.println(Arrays.toString(copy[0]));
original[0][1] = 7;
System.out.println(Arrays.toString(original[0]));
System.out.println(Arrays.toString(copy[0]));