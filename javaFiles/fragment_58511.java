System.out.println("Second Question !!");
        System.out.println("What was the currency unit for Ireland before the Euro was introduced?");
        System.out.println("Is it\n\t\tA)Pound\n\t\tB)Dollar\n\t\tC)Punt\n");
        System.out.println("Please select A B or C");
        System.out.println("Your current score is " + score);
        String w;
        boolean guessed = false;
        do{
            w = scan.nextLine();
            if (w.toLowerCase().equals("c")) {
                System.out.println("Correct!");
                score = score + 1;
                System.out.println("Your new score is " + score);
                guessed = true;
            } else if (w.toLowerCase().equals("b")) {
                System.out.println("Sorry that was incorrect!");
                guessed = true;
            } else if (w.toLowerCase().equals("a")) {
                System.out.println("Sorry that was incorrect!");
                guessed = true;
            } else {
                System.out.println("You pressed " + w + " Please choose A B or C");
            }
        }while (!guessed);