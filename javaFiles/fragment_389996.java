PrintStream outStream = new PrintStream(File outputFile);
for(int i = 5; i <= 100; i += 5)
{
    linearSurprise(i);
    outStream.println("Value of i: " + i);
}
outStream.close();