Scanner scanner = new Scanner(System.in);

String name = null;
do { //use do while loop for this
    if (name != null)
        System.out.println("Invalid Name \"" + name + "\" Try again");

    System.out.print("Enter Your Name: ");
    name = scanner.nextLine();

    //keep looping until name is only letters
} while (!name.matches("[A-Za-z]+"));

System.out.println("Welcome " + name);