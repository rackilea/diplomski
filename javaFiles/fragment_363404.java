public static void main(String[] args) {
    int n;
    System.out.println("Enter the No. Line:");
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();

    for (int i = 1; i < (2 * n); i++)
    {
        for (int j = 1; j <= i && j <= (2 * n) - i; j++)
        {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}