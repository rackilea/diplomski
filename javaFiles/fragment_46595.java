String quizStart;
        int quizAns1, quizAns2, quizAns3;
        int marks=0;

        Scanner input = new Scanner(System.in);

        System.out.println("Are you ready for a quiz? (y / n)");
        quizStart = input.next();

        System.out.println("Okay, here it comes!");

        // quiz answer 1

        System.out.println("\nWhat is the capital of Alaska? \n1) Melbourne\n2) Anchorage\n3) Juneau");
        quizAns1 = input.nextInt();

        if (quizAns1 == 3) {
            System.out.println("That's right");
            ++marks;
        } else {
            System.out.println("Your answer is wrong, sorry!");
        }

        // quiz answer 2

        System.out.println("Q2) Can you store the value ''cat'' in a variable of type int? \n1) yes \n2) no");
        quizAns2 = input.nextInt();

        if (quizAns2 == 1) {
            System.out.println("Sorry, ''cat'' is a string. ints can only store numbers.");
        } else if (quizAns2 == 2) {
            System.out.println("Correct!");
            ++marks;
        }

        // quiz answer 3

        System.out.println("What is the result of 9+6/3? \n1) 5\n2) 11 \n3) 15/3");
        quizAns3 = input.nextInt();
        if (quizAns3 == 2) {
            System.out.println("That's correct!");
            ++marks;
        } else {
            System.out.println("");
        }
        System.out.println("Overall, you got " +marks+" out of 3 correct. Thanks for playing!");