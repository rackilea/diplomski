import java.util.*;
class QuickSort
{
    static int partition(int A[],int p,int r)
    {
        int x = A[r];
        int i=p-1;
        for(int j=p;j<=r-1;j++)
        {
            if(A[j]<=x)
            {
                i++;
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
        }

        int temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;
        return i+1;
    }
    static void quickSort(int A[],int p,int r)
    {
        if(p<r)
        {
            int q = partition(A,p,r);
            quickSort(A,p,q-1);
            quickSort(A,q+1,r);
        }
    }
    public static void main(String[] args) {
        int A[] = {5,9,2,7,6,3,8,4,1,0};
        quickSort(A,0,9);
        Arrays.stream(A).forEach(System.out::println);
    }
}