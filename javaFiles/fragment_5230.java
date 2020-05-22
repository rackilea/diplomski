/**
 * @param args
 */
public static void main(String[] args) {
int m, n, p, q;

Scanner input = new Scanner(System.in);
System.out.println("Enter the number of rows and columns of first matrix");
m = input.nextInt();
n = input.nextInt();

System.out
    .println("Enter the number of rows and columns of second matrix");
p = input.nextInt();
q = input.nextInt();

System.out.println("Enter the elements of first matrix");

int first[][] = new int[m][n];
for (int c = 0; c < m; c++)
    for (int d = 0; d < n; d++)
    first[c][d] = input.nextInt();

System.out.println("Enter the elements of second matrix");
int second[][] = new int[p][q];

for (int c = 0; c < p; c++)
    for (int d = 0; d < q; d++)
    second[c][d] = input.nextInt();

MatrixApp matrixApp = new MatrixApp(first, second, m, n, p, q);
}