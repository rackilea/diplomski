final int range = 50;
    int answer = 0;
    int guesses;
    int number;
    int guessNum = 0;

    String choice = "";
    boolean Loop = false;

    Scanner input = new Scanner(System.in);
    Random r = new Random();

    answer = r.nextInt(range) + 1;

    System.out.println("IF YOU WISH TO GIVE UP, PRESS 0 ON THE KEYBOARD");

    while (!Loop)
    {
        int exit;
        for (exit = 0; exit < 10; exit++)
        {
            System.out.print("Guess a number between 1 and " + range + " : ");
            number = input.nextInt();
            guessNum = guessNum++;
            guessNum += 1;

            if (number == answer)
            {
                System.out.println(" Your guess was correct ");
                System.out.println();
                System.out.println("The number was: " + answer);
                System.out.println("You guess the number with: " + guessNum + " guesses ");
                System.out.println();
                System.out.println("Enter x to continue to play or y to endgame");
                choice = input.next();

                // HERE YOU ARE DOING THE WRONG THING
                // What is the meaning of "not(!)" here ? !choice.equalsIgnoreCase("x")
                // Remove "NOT(!)" from here your program will work as expected

                if (choice.equalsIgnoreCase("x"))
                {
                    //here you should assign loop to false if they continue
                    Loop = false;
                    answer = r.nextInt(range) + 1;
                    System.out.print("A new number");
                    break;
                }
                else if (choice.equalsIgnoreCase("y"))
                {
                    //better to insert break here as well
                    //here you should assign loop to true if they wanna exit.
                    Loop = true;
                    System.out.print("END OF GAME");
                    exit = 11;
                    break;
                }
            }

            else if (number > answer)
            {
                System.out.println("TOO HIGH");
            }
            else if (number < answer)
            {
                System.out.println("TOO LOW");
            }

            if (number == 0)
            {
                System.out.println("YOU GAVE UP. THE NUMBER WAS " + answer);
                System.out.println("Enter x to continue to play or y to endgame");

                // MADE CHANGES HERE

                choice = input.next();

                if (choice.equalsIgnoreCase("x"))
                {
                    //here you should assign loop to false if they continue
                    Loop = false;
                    answer = r.nextInt(range) + 1;
                    System.out.print("A new number");
                    break;
                }
                else if (choice.equalsIgnoreCase("y"))
                {
                    //better to insert break here as well
                    //here you should assign loop to true if they wanna exit.
                    Loop = true;
                    System.out.print("END OF GAME");
                    exit = 11;
                    break;
                }
            }

        }
    }