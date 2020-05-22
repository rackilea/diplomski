public static void main(String[] args) {
    int sum = 0;

    int n = MyConsole.readInt("Enter number of grades: " );

    for (int i = 0; i < n; i++) {
        int a = MyConsole.readInt("Enter grade "+ (i + 1) + ": ");
        sum += a;
    }

    double average = sum / n;

    System.out.println("Average value of array elements is : " + average);