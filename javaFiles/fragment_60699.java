int[] a = new int[10];
Scanner input = new Scanner(System.in);
System.out.println("Please enter ten numbers: ");
for (int j = 0; j < a.length; j++) {
    a[j] = input.nextInt();
}
System.out.println("Your number list is: ");
System.out.println(Arrays.toString(a));