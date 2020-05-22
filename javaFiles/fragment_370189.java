class Testing
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int arraySize = 0;
        while(arraySize > 6 || arraySize < 3)
        {
            //Get user input here.
        }
        String[] names = new String[arraySize];
        for(int i = 0; i < names.length; i++)
        {
            System.out.println("Please enter a family member's name: ");
            names[i] = scanner.next();
        }

        generateNewName(names);
    }

    public static void generateNewName(String[] names)
    {
        for(int i = 0; i < names.length; i++)
        {
            System.out.print(names[i].charAt(1));
        }
    }
}