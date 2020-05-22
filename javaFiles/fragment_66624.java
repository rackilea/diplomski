for (int i=0; i<key.length; i++) {
  System.out.print("Student's answer for question " + (i+1) + ": " );
  answers = scan.nextInt();

  if (answers == key[i])  
     score++;    
  }