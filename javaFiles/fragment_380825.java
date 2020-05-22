if ( guess == answer)
        {
        numberOfTries += 1;   // <--- This adds the final guess
        System.out.println ("YOU WIN!");
        System.out.println("It took you " + numberOfTries + " tries!") ;
        System.out.println();
        System.out.print( "Do you want to play again(Y/N)?");
        }