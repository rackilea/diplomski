import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int a[] = new int[10000];
        int b[] = new int[10000];
        int c[] = new int[10000];
        Arrays.fill(a,1);
        Scanner in = new Scanner(System.in);
        for(int i=2;i<1000;i++)
            if(a[i]==1)
                for(int j=i*i;j<10000;j+=i)
                    a[j]=0;
        b[0]=0;
        int k=1;
        for(int i=2;i<10000;i++)
            if(a[i]==1)
            {
                b[k]=i+b[k-1];
                c[k]=i;
                k++;
            }
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            System.out.println(b[n]);
        }
    }   
}