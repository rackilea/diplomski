public static void main(String [] args) throws Exception 
{
   int[] numbers = new int[args.length];
   try
    {
        for (int i = 1; i < args.length; i+=2)
        {

            number[i-1] = Integer.parseInt(args[i-1].split(" ")[0];
            number[i] = Integer.parseInt(args[i].split(" ")[0];
            System.out.println("("+number[i-1]+","+number[i]+")");
        }
    }
    catch (NumberFormatException e)
    {
        System.out.println(e.getMessage());
    }
}