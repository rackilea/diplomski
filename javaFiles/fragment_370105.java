void printReversed(int n)
{
   String line = reader.readLine();

   if (n > 0)
     printReversed(n-1);

   System.out.println(line);
}