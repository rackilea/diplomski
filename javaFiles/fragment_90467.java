public static void main(String [] args) 
{

     int[] numbers = new int[args.length];
       try
        {
            for (int i = 1; i < args.length; i += 2) 
            {

                numbers[i-1] = Integer.parseInt(args[i-1]);
                numbers[i] = Integer.parseInt(args[i]);
                System.out.println("("+numbers[i-1]+","+numbers[i]+")" + "    has signs " + checkSigns(numbers[i-1], numbers[i]) + " and is in " + fromInts(numbers[i-1], numbers[i]));
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println(e.getMessage());
        }
}