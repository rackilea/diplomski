// a main method that reads in ints and then keeps them as such
Scanner in = new Scanner(System.in);
int t = in.nextInt();
while (t > 0) {
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = in.nextInt();
    }
    int count = countGroupsOfTwo(arr);
    count += countGroupsOfThree(arr);
    System.out.println(count);
    t--;
}