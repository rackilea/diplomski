public boolean isANumber (String s)  
{
   for (int i = 0; i < s.length(); i++)
   {
      if (!Character.isDigit(s.charAt(i)))
      {
        return false;
      }
   }
   return true;
}