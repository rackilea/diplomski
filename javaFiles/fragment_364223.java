class PrimeNumbers{
public static void main(String args[])
{
    boolean flag;
    for(int i=1;i<=100;i++)
    {
        flag = true;
        for(int j=2;j<=(i/2);j++){
            if(i%j==0)
                flag = false;;
        if(flag == true)
           System.out.println(i);
    }
}