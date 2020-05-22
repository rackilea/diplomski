do
        try {
            System.out.print("Please enter first Integer: ");
            a = Integer.parseInt(userInput.next());
            System.out.print("Please enter second Integer: ");
            b = Integer.parseInt(userInput.next());
            if (a >= 9000 || b >= 9000)
                throw new StackOverflowError();
            break;

        } catch (NumberFormatException e) {

            System.out.println("Must enter an integer!");

        } catch (StackOverflowError e) {

            System.out.println("Thats too much");

        }
    while (true);