import java.util.*;
class pr9
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int x,i,j;
        int SECOND_ARRAY_SIZE = 0;
        System.out.println("Enter Length of the Array");
        x=sc.nextInt();
        int a[]=new int[x];

        for(i=0;i<x;i++)
        {
            System.out.println("Enter " +x+" Numbers");
            a[i]=sc.nextInt();
            if(a[i] > 0)
                SECOND_ARRAY_SIZE++;
        }

        int b[]=new int [SECOND_ARRAY_SIZE];

        for(i = 0, j = 0; i < x; i++)
        {
            if(a[i]<0)
                a[i]=0;
            else if(a[i] > 0)
            {
                b[j] = a[i];
                j++;
            }
        }

        // Easier to read
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        // What you want
        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + " ");
        }

        System.out.println();

        for (int l = 0; l < b.length; l++) {
            System.out.print(b[l] + " ");
        }
    }
}