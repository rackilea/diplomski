//Determines the total incorrect answers
   public int totalIncorrect()
   {
      int incorrectCount = 0; 

      for (int i = 0; i < correctAnswers.length; i++)
      {
         if (!userAnswers[i].equalsIgnoreCase(correctAnswers[i]))
         {
            missed[incorrectCount] = i; 
            incorrectCount++; 
         }
      }
      return incorrectCount; 
   }