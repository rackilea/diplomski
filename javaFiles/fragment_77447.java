Scanner sc=new Scanner(System.in);
System.out.println("Enter number of rows");
int row=sc.nextInt();

for (int i=1; i<row+1; i++) {
    for (int j=1; j<row+1; j++) {
        if (j > row - i) {
            System.out.print(j);
        } else {
            System.out.print(" ");
        }
    }
    System.out.println();
}