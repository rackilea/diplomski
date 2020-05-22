public class MaxDouble 
{
    public static void main (String[]  args)
    {
        Scanner inp = new Scanner(System.in);    
        System.out.println ("Enter the three double numbers separated by spaces");       
        double d1 = inp.nextDouble();
        double d2 = inp.nextDouble();
        double d3 = inp.nextDouble();
        double result = maximum (d1, d2, d3);

        System.out.println ("Maximum is"+ result);               
    }

    public static double maximum (double x, double y, double z)
    {
        double maxValue = x;
        if (y > maxValue)
            maxValue = y;
        if (z > maxValue)
            maxValue = z;

        return maxValue;
    }       
}