public class Test1  
{

    public static void main(String[] args) throws Exception 
    {
        long   long1 = Long.MAX_VALUE - 100L;
        double dbl1  = long1;
        long   long2 = long1+1;
        double dbl2  = dbl1+1;
        double dbl3  = dbl2+Math.ulp(dbl2);

        System.out.printf("%d %d\n%f %f %f", long1, long2, dbl1, dbl2, dbl3);
    }

}