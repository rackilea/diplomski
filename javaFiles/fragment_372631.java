public char getMostCommon()
{
     int max = 0;
     int current_index = 0; // current character index
     for(int i = 0; i < counts.length; i++)
     {
          if(counts[i] > max)
          {
               max = counts[i]; // Getting the value of the frequency
               current_index = i; // And the value of the character index
          }
      }
      // Finally parsing the index
      char c = Character.toLowerCase((char)(current_index + 'a'));
      return c;
}