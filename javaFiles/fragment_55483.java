while (!check) {
    try {
        startingBalance = input.nextDouble();
        check = true;
    } catch (InputMismatchException e) {
        System.out.println("Invalid input!");
        input.nextLine();//this will clear your Scanner and repeat again
    }
}