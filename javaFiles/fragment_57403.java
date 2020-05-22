Scanner fileToRead = new Scanner(new File("c:\\hard-coded-file.txt"));

while (fileToRead.hasNext()) { 
    if (fileToRead.hasNextDouble())
    {
        System.out.println(fileToRead.nextDouble());
    } 
    else 
    {
        fileToRead.next();
    }   
}