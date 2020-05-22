{
     // Creating a new keyboard input
    Scanner scanner = new Scanner(System.in);


   int room;   
   do {
      // Displaying a message on the screen
      System.out.println("What room are you in? ");
      room = scanner.nextInt();
   } while( !isValid(room) );

   ... //if else or switch
}

private boolean isValid(int room){
   if(room > 4 || room  < 1){
       System.out.println("Try again ;)" );
       return false;
   }  else return true;
}