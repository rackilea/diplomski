for (int i = 0; i < numShuffles; i++) {
        int num1 = 7 + random.nextInt(7);
        int num2 = 7 + random.nextInt(7);
        int num3 = 7 + random.nextInt(7);


        System.out.println(num1 + " + " + num2 + " + " + num3 + " = " + (num1 + num2 + num3));
        numberStore.add(num1 + num2 + num3);


        int lastNumber = num1 + num2 + num3;

        boolean lastShuffle = (i == (numShuffles - 1));
        if (lastShuffle) {
            if (lastNumber == 31) {
                System.out.println("Congratulations !! You are the Lucky Winner !!!!");
            } else {
                System.out.println("Better Luck Next Time");
            }
        }
    }
    // play again prompt
    System.out
        .println(" Do you want to play again? (If you do enter y or yes) \n To exit press any other key ");
    String input = user_input.next();
    if (!"y".equalsIgnoreCase(input) && !"yes".equalsIgnoreCase(input)) {
        break;
    }