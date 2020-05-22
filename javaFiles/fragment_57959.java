Scanner scan = new Scanner(System.in);
int arr[] = new int[10];
for (int i = 0; i < arr.length; i++) {
    System.out.print("Enter numbers " + (i+1) + " : ");
    arr[i] = scan.nextInt();
}

Arrays.sort(arr);
int totalUnique = 1;
for (int i = 0; i < arr.length - 1; i++) {
    if (arr[i] != arr[i+1]) {
        totalUnique += 1;
    }
}
System.out.print(totalUnique + " distinct numbers were entered");