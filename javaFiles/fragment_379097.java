String filename = "file.txt";
List<String> lines = new ArrayList<String>();
try (BufferedReader br = new BufferedReader(new FileReader(filename)))
{
    String str;
    while ((str = br.readLine()) != null)
    {
        lines.add(str);
    }
}
catch (IOException ioe)
{
    //handle errors
}

while (lines.size() > 0)
{
    //we know that lines is more than 0 so remove the first element
    String nextLineOut = lines.remove(0);
    for (int charIndex = 0; charIndex < nextLineOut.length(); charIndex++)
    {
        System.out.print(nextLineOut.charAt(charIndex));
        try
        {
            //every time a character is printed to the console sleep for 50 milliseconds
            Thread.sleep(50);
        }
        catch (InterruptedException ie)
        {//handle errors
        }
    }
    //we have reached end of line so print out a new line
    System.out.print(System.lineSeparator());
}