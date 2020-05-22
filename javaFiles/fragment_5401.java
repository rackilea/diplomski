public static void main(String[] args) {
    int n;
    int startingnumber;

    Scanner input = new Scanner(System.in);

    System.out.print("Enter the height of the triangle: ");
    n = input.nextInt();
    startingnumber = n * (n + 1) / 2;
    System.out.println("The first number is " + startingnumber);

    for (int i = 1; i <= n; i++) {

        for (int j = 1; j <= i; j++) {
            System.out.printf("%3d ", startingnumber);
            startingnumber--;
        }

        System.out.println();
    }
}