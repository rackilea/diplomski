public static String stringToEnglish( String text )
{
   String newEnglish = ""; //sets string for newEnglish
   String selectedEnglish; //sets string for selectedEnglish
   String convertedEnglish; //sets string for convertedEnglish
   String[] morseChars = text.split(" ");
   for (int i = 0; i < morseChars.length; i++)
   {
       //Select the next Morse character
       selectedEnglish = morseChars[i];
       boolean endsWithWordSeparator = selectedEnglish.endsWith("|");
       if(endsWithWordSeparator) selectedEnglish = selectedEnglish.substring(0, selectedEnglish.length() - 1);
       // Convert the string
       convertedEnglish = decode(selectedEnglish);

       newEnglish = newEnglish + convertedEnglish;
       if (endsWithWordSeparator) 
       {
           newEnglish = newEnglish + " ";
       }
   }

   return newEnglish;
}