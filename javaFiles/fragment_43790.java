public static void main(String[] args)
{
    String name = null;
    int i = 0;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    try
    {
        Scanner keybord = new Scanner(System.in);
        System.out.println("enter in file name");
        String filename = keybord.nextLine();
        Scanner file = new Scanner(new File(filename));

        while (file.hasNext())
        {
            name = file.next();
            System.out.println(name + " ");

            while (file.hasNextInt())
            {
                i = i + file.nextInt();
            }
            if (i < min)
            {
                min = i;
            }
            System.out.println("min " + min);
            if (i > max)
            {
                max = i;
            }
            System.out.println("max " + max);
            i = 0;
        }
    } catch (IOException e)
    {
        System.out.println("File does not exist");
    }
}