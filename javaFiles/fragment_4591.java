public static char[][] Frame_of_zeros(char[][]a)//builds an external frame of zeroes
{
    char[][]c3=new char[a.length+2][a[0].length+2];
    for(int i=0,j=0;i<c3.length;i++)//left column is composed of zeroes
    {
        c3[i][j]='0';
    }
    for(int j=0,i=0;j<c3[0].length;j++)//upper row of zeroes
    {
        c3[i][j]='0';
    }
    for(int i=c3.length-1,j=0;j<c3[0].length;j++)//most lower row composed of zeroes
    {
        c3[i][j]='0';
    }
    for(int i=0,j=c3[0].length-1;i<c3.length;i++)//right column is composed of zeroes
    {
        c3[i][j]='0';
    }

    for(int i=1,k=0;i<c3.length-1 && k<a.length;i++,k++)//i for the modified and k is the original
    {
        for(int j=1,l=0;j<c3[0].length-1 && l<a[0].length;j++,l++)//j for the modified and l is the original
        {
            c3[i][j]=a[k][l];
        }
    }
    return c3;
}