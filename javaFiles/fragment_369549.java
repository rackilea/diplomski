public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    System.out.println(add(a, 0, 0)); // Receives the final value from add
}

private static int add(int[] arr, int index, int sum) {
    if (index == arr.length) {
        // You could print 'sum' here, but may as well return it to the main function and print it there.
        return (sum);
    }   
    sum += arr[index]; 
    else {
      return sum + add(arr, --n, sum);
    }
}