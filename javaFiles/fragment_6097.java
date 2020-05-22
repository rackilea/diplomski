Scanner scanner = new Scanner(System.in);

System.out.print("Number of elements in array B = ");
int y = scanner.nextInt();

int B[] = new int[y];

System.out.println("Enter the elements of array B : ");
for (int i = 0 ; i < y ; i++ ) {
    B[i]= scanner.nextInt();
}