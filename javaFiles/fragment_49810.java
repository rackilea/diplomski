import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int len = in.nextInt();
        System.out.println("Enter the elements");
        int[] arr = new int[len];
        for(int i=0; i<len;i++)
        {
            arr[i] = in.nextInt();
        }
        System.out.println("Enter number of times to rotate");
        int k = in.nextInt();
        int[] arr1 = new int[k];
        for(int i=0;i<=k-1;i++)
        {
            arr1[i]=arr[i];
        }

        int[] arr2 = new int[len];
        int j = 0;
        for(int i=k;i<=len-1;i++, j++)
        {
          arr2[j]=arr[i];
        }

        for(int i=0;i<=k-1;i++, j++)
        {
          arr2[j]=arr1[i];  
        }
        for(int i=0;i<=len-1;i++)
        {
            System.out.println(arr2[i]);
        }
    }

}