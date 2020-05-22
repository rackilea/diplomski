for(int i=0;i<d;i++)
{
    for(int j=0;j<i;j++)
    {
        System.out.print(a[i][j]);
    }        

    System.out.print(" ");

    for(int j=i;j<d;j++)
    {
        System.out.print(a[i][j]);
    }
    System.out.println();
}