int[] a = { 1, 2, 3, 4 };
int[] b = { 5, 6, 7, 8 };

System.out.printf("Before: a=%s b=%s%n", a, b);

a = b;

System.out.printf("After: a=%s b=%s%n", a, b);

b[2] = 9;

System.out.println(Arrays.toString(a));