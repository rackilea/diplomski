public String toString()
{
   String result = name + "\n";
   for (int index = 0; index < count.length; index++) {
       result = result + index + ": "; // New
       for (int indexStar = 0; indexStar < count[index]; indexStar++) // New
           result = result + "*"; // New
       result = result + "\n"; // New
   }
   return result;
}