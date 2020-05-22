try {
    System.out.print("Enter height: ");
    height = keyboard.nextInt();

    if (height < 3 || height > 10) {
        System.out.println("Invalid height.");
        System.exit(0);
    }
    // print triforce from zelda
    // ...
} catch (InputMismatchException e) {
    System.out.println("please input a int");
}