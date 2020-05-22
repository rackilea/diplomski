import java.util.*;
public class Main{

public static void main(String[] args) 
{
    int n1, n2 , n3, i;
    int count=0;
    int sum1=0,sum2=0,sum3=0;

    Scanner s = new Scanner(System.in);
    n1=s.nextInt();
    n2=s.nextInt();
    n3=s.nextInt();

    int[] arr1=new int[n1];
    int[] arr2=new int[n2];
    int[] arr3=new int[n3];

    for(i=0;i<n1;i++) 
        arr1[i]=s.nextInt();
    for(i=0;i<n2;i++) 
        arr2[i]=s.nextInt();
    for(i=0;i<n3;i++) 
        arr3[i]=s.nextInt();

    while(count==0){    

    for(i=0;i<n1;i++) {
        sum1+=arr1[i];
    }
    for(i=0;i<n2;i++) {
        sum2+=arr2[i];
    }
    for(i=0;i<n3;i++) {
        sum3+=arr3[i];
    }

    if(sum1==sum2&&sum2==sum3) {
        count++;
    }
    else {
        if(sum1>sum2&&sum1>sum3) {
            arr1[n1-1]=0;
        }
        if(sum2>sum1&&sum2>sum3) {
            arr2[n2-1]=0;
        }
        if(sum3>sum1&&sum3>sum2) {
            arr3[n3-1]=0;
        }

    }
}
    if(count>0){
        System.out.println("Condtion Satisfied");
    }

}
}