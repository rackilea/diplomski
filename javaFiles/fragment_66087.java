public int countLines(File inFile)
{
   int count = 0;
   Scanner fileScanner = new Scanner(inFile);

   while(fileScanner.hasNextLine()) //if you are trying to count lines
   {                                //you should use hasNextLine()
       fileScanner.nextLine() //advance the inputstream
       count++;
   }

   return count;
}