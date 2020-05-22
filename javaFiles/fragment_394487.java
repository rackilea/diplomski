String userInput = null;
        int term = 0;
        int lastTerm = 0;
        int sum = 0;
System.out.println("It is a simple series sum problem. Prepared by -------");
        System.out.println("Enter first term between 1 to 100:");
        term = input.nextInt();
        while (term < 0 || term > 100) {
            System.err.print("Error: Enter the first term between 1 to 100");
            term = input.nextInt();


        }
        System.out.println("Enter last term:");
        lastTerm = input.nextInt();
        while (lastTerm <= term) {
            System.err.print("Error: Enter an integer greater than " +  term);
            lastTerm = input.nextInt();
        }
        // Edit start
        for (int i = term; i<=lastTerm; i++) {
            sum += i;
        }
        System.out.println("Sum:" + sum);
        // Edit end