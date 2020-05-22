Scanner input = new Scanner(System.in);
    while(true){
        try {
            int choice = input.nextInt();
            System.out.println("Input was " + choice);
        } catch (InputMismatchException e){
            String bad_input = input.next();
            System.out.println("Bad input: " + bad_input);
            continue;
        }
    }