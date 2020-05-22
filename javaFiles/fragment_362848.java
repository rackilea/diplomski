import java.util.*;
class Array13
{
public static void main(String args[])
{
int arr[][]={{1,2,3},
    {1,3,2},
        {2,1,3},
        {2,3,1},
    {3,1,2},
        {3,2,1}};
System.out.println("Enter the row number :");
Scanner sc=new Scanner(System.in);
int r = sc.nextInt();


printVal(arr,r-1);

}
public static void printVal(int mat[][],int row)
{
for(int i=0;i<mat.length;i++)
{
if(i == row)
{
for(int j=0;j<mat[row].length;j++)
{
System.out.print(mat[i][j]);
System.out.print(" ");
}
}
}
}

}