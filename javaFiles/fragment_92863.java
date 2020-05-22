while(!A)
{ 
       System.out.println ("You enter a room and look around, in it, you see three     doors, a red door labeled A, a blue door labeled B, and a green door labeled C.  Which door do you choose to go through? Enter, A, B, or C");
       String correctdoor = scanner.next();

       A = "A".equalsIgnoreCase(correctdoor);

       if (!A) // Added this here, displays the message only if they chose the incorrect door
       {
           System.out.println("You have chosen wrong! You have fallen into a pit! Lucky for you though, the pit is easy to climb out of and you return to the room....\n\n\n");
       }
}