int[] x = { 1, 2, 3, 4, 5 };
int[] y = x;

y[0] = 10;
System.out.println(Arrays.toString(x)); // 10, 2, 3, 4, 5
y = new int[] { 3, 3, 3, };
System.out.println(Arrays.toString(x)); // 10, 2, 3, 4, 5