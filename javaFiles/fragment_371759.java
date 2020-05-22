public class Factorial {


    public int facto()
    {
    int fact=1;
    int n=5,i=1;

        for(i=n;i>=1;i--)
        {
            fact=fact*i;
        }
     return fact;
    }

    public static void main(String args[])
    {
        Factorial obj1= new Factorial();
        System.out.println(obj1.facto());
    }
}