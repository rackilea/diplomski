Scanner scan;
try
{
    File myFile =new File("fileName.txt");
    scan = new Scanner(myFile);
    System.out.println("Scanner creation succesful");
}
catch(FileNotFoundException e)
{
    System.out.println("File not found");
    System.exit(1);
}