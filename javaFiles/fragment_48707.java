int[] arr = { 1 };
int[] arrCopy = Arrays.copyOf(arr, arr.length); // <-- deep copy
int[] b = arr; // <-- shallow copy
b[0] = 2; // <-- same as arr[0] = 2
System.out.printf("arr = %s, arrCopy = %s, b = %s%n", //
        Arrays.toString(arr), Arrays.toString(arrCopy), //
        Arrays.toString(b));