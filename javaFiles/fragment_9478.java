while (!input.equals("stopnow"))    
  {
   outputFile.println(input); // print input to the file    
   System.out.println("Please enter the next word or stopnow to end"); //Prompt user for a word
   input = kb.nextLine(); // assign input as the word    
  }