public ArrayList<String> getRawWords(String s) 
{
   String[]  s2 = s.split(" ");
   ArrayList<String> words = new ArrayList<String>();

   for(int x =0; x< s2.length-1;x++)
   {
        words.add(s2[x]);
   }
   return words;
}