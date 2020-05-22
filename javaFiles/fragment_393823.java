Scanner poem2 = null;
try 
{
    poem2 = new Scanner (new File("prog512h.dat.txt"));
}
catch (FileNotFoundException e) 
{
    System.out.println ("File not found!"); // returns error if file is not found
    System.exit (0);
}

while(poem2.hasNext()) 
{       
    System.out.println(poem2.nextLine());
}