public class Prime 
{
    public static void main(String[] args) 
    {
       for(int i = 1; i <= 10; i++)
       {
         if (isPrimeNumber(i) == 1)
         {
            System.out.println(i+ " is a prime Number");
         }
       }
    }


    public static int isPrimeNumber(int i) {
        int factors = 0;
        int j = 1;

        while(j <= i)
        {
            if(i % j == 0)
            {
                factors++;
            }
            j++;
        }
        int flag = 0;
        if(factors == 2){
            flag = 1;
        }
        return flag;

  }
}