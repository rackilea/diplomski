do {
    Scanner input = new Scanner(System.in);
    while (!input.hasNextInt() || input.nextInt() > 5) {
        System.out.println("Enter a valid integer!");
        //OR String a = input.nextLine():
        getMenu();
        input.next();
    }