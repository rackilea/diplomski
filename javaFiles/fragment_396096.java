// Generate two random numbers 
   int  rand1 = (int) (Math.random() * nameLength);
   int  rand2 = (int) (Math.random() * actionLength);
   int  rand3 = (int) (Math.random() * nameLength);

   String phrase1 = name[rand1];
   String phrase2 = action[rand2];
   String phrase3 = name[rand3];

   System.out.print("It is obvious that" + ' ' + phrase1 + " " + "is a better" + " " +  
   phrase2 + " " + "than" + " " + phrase3 + "!" );