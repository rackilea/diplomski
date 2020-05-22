public static void main(String[] args)
{
   String toGuess="";

   do { // Always try to generate at least one number.
       toGuess = ""; //Reset each time we loop.

       for(int i=0; i<4; i++) {
            Random rando= new Random();
            int rd=rando.nextInt(9);
            toGuess=toGuess+rd;
        }
    } while(!IsValidNumber(toGuess));

    System.out.println(toGuess);
}