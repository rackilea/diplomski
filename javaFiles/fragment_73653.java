public static void main(String[] args)


 throws java.io.IOException {
       int hundred; //my compiler was fussy about having the extra class
       int tens;
       int ones;
       char input = ' '; //initialize outside loop
       Scanner s = new Scanner(System.in);



   do {

       System.out.print("Enter an integer: ");
       int wholeNumber = s.nextInt();

       ones = wholeNumber % 10;
       tens = (wholeNumber / 10) % 10;
       hundred = (wholeNumber / 100) % 10;

       System.out.println("show (W)hole number.");
       System.out.println("show (O)nes place number.");
       System.out.println("show (T)ens place number.");
       System.out.println("show (H)undreds place number.");
       System.out.println("(Q)uit");
       System.out.print("Enter your choice: ");
       input = s.next().trim().charAt(0); //using scanner only
       //System.out.println("Enter your choice: " + input);

       if (input == 'W' || input == 'w') {
           System.out.println(wholeNumber);
       } else if (input == 'O' || input == 'o') {
           System.out.println(ones);
       } else if (input == 'T' || input == 't') {
           System.out.println(tens);
       } else if (input == 'H' || input == 'H') {
           System.out.println(hundred);

       }
   } while ((input != 'q') && (input != 'Q'));


}

   }