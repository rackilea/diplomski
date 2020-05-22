int lightcode = 0; //Initialize lightcode to something incorrect here
while (!(lightcode == 31425))
{
 System.out.println("You progress through the door and find 5 light switches, you must turn them on in order to progress further. Enter the correct combination (using digits 1-5) here please.  HINT - the 2nd and 4th numbers add up to the first number and the last number is NOT 5");   
    lightcode = scanner.nextInt(); //Get lightcode from the player

    if (!(lightcode == 31425)) //And finally, only if the code is INCORRECT, display the incorrect message
    {
     System.out.println ("That combination is incorrect");
    }
}

System.out.println ("The door unlocks and you go down a set of stairs");