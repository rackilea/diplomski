public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of grades: " );
    int n = sc.nextInt();

    int sum = 0;

    for (int i = 0; i < n; i++) {
        System.out.print("Enter grade "+ (i + 1) + ": ");
        int a = sc.nextInt();
        sum += a;
    }

    double average = sum / n;

    System.out.println("Average value of array elements is : " + average);
}