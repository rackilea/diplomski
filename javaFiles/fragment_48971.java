public static void main( String[] args )
{
    Scanner input = new Scanner (System.in);
    Scanner sc = null;
    try 
    {

        sc = new Scanner (new FileReader("E:\\Documents\\Java\\Hackathon2016\\Sample_Folder\\Monday.txt"));
        System.out.println("Enter Subject Code");
        String subject = input.next();
        while (sc.hasNext())
        {
            String time = sc.next();
            String subjects = sc.next();
            String prof = sc.next();
            String room = sc.next();

            if (subject.equalsIgnoreCase (subjects))
            {
                System.out.print ("Your Schedule is at "+time+subject+prof+room);
            }
        }
    }
    catch (IOException e)
    {
        e.getMessage ();
    }    
}