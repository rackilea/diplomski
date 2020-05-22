public static void main (String [] args)
{
    System.out.println("Enter size of array (in form nxn), n:");
    n = console.nextInt();
    rows = n;
    columns = n;
    listSize= (n*n);    
    int [] list = new int [listSize];
    createArithmeticSeq (list);
    int [] [] matrix = new int [rows] [columns];
    matricize(list, matrix);
    printMatrix(matrix);
    System.out.print("\n");
    reverseDiagonal(matrix);
    printMatrix(matrix);
    magicCheck(list, matrix);   
}