while(lineOfText != null)
{
   if (!lineOfText.isEmpty())
   {
      outputFile.println(lineOfText);
   }
   lineOfText = inputFile.readLine();
}