int[] array, array2;
Scanner in = new Scanner(System.in);

int a, b;

a = in.nextInt();
b = in.nextInt();

array = new int[Integer.toString(a).length()];
array2 = new int[Integer.toString(b).length()];

int i = 0;
while(a > 0) {
    array[i] = a % 10;
    a /= 10;
    i++;
}

i=0;
while(b > 0) {
    array2[i] = b % 10;
    b /= 10;
    i++;
}

System.out.println(Arrays.toString(array));
System.out.println(Arrays.toString(array2));