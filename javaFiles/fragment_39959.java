public class SumOfColumn 
{
public static void main(String[] args) 
 {
    int i,j;
    int a[][]={{22,33,44,11},{33,55,77,11},{44,11,88,55},{33,55,22,77}};
    int res[]={0,0,0,0};
    for(i=0;i<4;i++)
     {
         int sum=0;
         for(j=0;j<4;j++)
         {
             System.out.print(a[i][j]+ "\t" );
             sum = sum + a[j][i];
         }
        res[i]=sum;
        System.out.println(sum);    
        System.out.println();
    }
    System.out.println("-------------------");
    for(i=0;i<4;i++)
    {
        System.out.print(res[i]+ "\t" );
    }
    System.out.println();
   }
}