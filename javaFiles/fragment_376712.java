public class ArraySort{
    private final Scanner scanner = new Scanner(System.in);

    int sizeRow, sizeColumn;

    public boolean getArraySize() throws IOException
    {
        try
        {
            System.out.print("Enter the size of the row:");
            sizeRow = (scanner.nextInt());
            System.out.print("Enter the size of the column:");
            sizeColumn = scanner.nextInt();
            return false;
        }
        catch (NumberFormatException e)
        {
            System.out.println("Enter valid value for size:");
        }
        return true;
    }    
    ...
}