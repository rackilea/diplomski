if (compVal == userOriginal) {
            System.out.println("It was a tie!");
        } else
        {
            //R
            if (compVal == 1)
            {
                if (userOriginal == 2) {
                    System.out.println("You played Paper and I chose Rock: Paper covers Rock so you win this time!");
                }
                if (userOriginal == 3) {
                    System.out.println("You played Scissors and I chose Rock: Rock crushes Scissors so I win this time!");
                }
            }
            //P 
            if (compVal == 2)
            {
                if (userOriginal == 1) {
                    System.out.println("Your played Rock and I chose Paper: Paper covers rock so I win this time!");
                }
                if (userOriginal == 3) {
                    System.out.println("You played Scissors and I chose Paper: Scissors cuts Paper so you win this time!");
                }
            }
            //S
            if (compVal == 3)
            {
                if (userOriginal == 1) {
                    System.out.println("You played Rock and I chose Sciccors: Rock crushes Scissors so you win this time");
                }
                if (userOriginal == 2) {
                    System.out.println("You played Paper and I chose Scissors: Paper is cut by Scissors so I win this time!");
                }
            }
        }