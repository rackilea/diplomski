import java.util.*;
class Test{
    public static void main(String []args)
    {
        long num,sum=0;

        Scanner sc=new Scanner(System.in);
        String data=sc.nextLine(); 
        Scanner sc2=new Scanner(data);
        while(sc2.hasNextInt())
        {
            num=sc2.nextInt();
            sum=sum+num*num*num;
        }
        System.out.println(sum);
    }
}