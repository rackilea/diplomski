while(lineOfText != null)
{
   if (lineOfText.isEmpty())
   {
    outputFile.print("null");
   }
   outputFile.println(lineOfText);
   lineOfText = inputFile.readLine();
}