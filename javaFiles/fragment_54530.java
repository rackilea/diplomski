while (number > attempt || number<attempt) 
       {
        if(number>attempt){
           System.out.println("I imagined a bigger number. Guess again!");}             
        else
           System.out.println("I imagined a smaller number. Guess again!");

        attempt = input.nextInt();
        counter++;
       }
if (number == attempt)
   {

       counter++;
   }


   System.out.println("You guessed from " + counter +". attempt" );

}