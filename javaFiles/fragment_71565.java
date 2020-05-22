int[] arr = { 2, 1, 1, 3, 3, 2, 2, 2, 2, 1, 1 };
int index = 0, count = 0;
for (int i = 0; i < arr.length; i++) {
    int r = runsTo(arr, i);
    int c = r - i + 1;
    if (c > count) {
        index = i;
        count = c;
        i += count - 1;
    }
}
System.out.println(Arrays.toString(arr));
System.out.printf("Starting from %d get %d%n", index, count);
System.out.println(Arrays.toString(Arrays.copyOfRange(arr, index, index + count)));