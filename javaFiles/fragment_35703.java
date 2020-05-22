public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Let’s play a game called “Odds and Evens”");
    System.out.println("What is your name?");
    name = input.next();
    while (true) {

        System.out.println("Hello " + name + " which one do you choose? (O)dds or (E)vens?");
        oe = input.next();

        if (oe.equalsIgnoreCase("e")) {
            System.out.println(name + " has picked evens! The computer will be odds.");
            break;
        }
        if (oe.equalsIgnoreCase("o")) {
            System.out.println(name + " has picked odds! The computer will be evens.");
            break;
        } else {
            System.out.println("You have typed an invalid answer, lets try again");
        }
    }

    while (true) {
        System.out.print("How many \"fingers\" do you put out? ");
        finger = input.nextInt();
        if (finger >= 0 && finger <= 5) {
            break;
        } else {
            System.out.println("Please write a number between 0 and 5");
        }
    }

    Random rand = new Random();
    int computer = rand.nextInt(5) + 0;
    System.out.println("Computer plays number " + computer);
    System.out.println("----------------------------------------------");

    int sum = finger + computer; //1<------------------------------
    if (sum % 2 == 0) {
        System.out.println(sum + " is even!");
        if (oe.equalsIgnoreCase("e") && (sum % 2 == 0)) {
            System.out.println(name + " wins!");
        } else {
            System.out.println("Computer wins!");
        }
    }

    else {
        System.out.println(sum + " is odd!");
        if (oe.equalsIgnoreCase("o") && (sum % 2 != 0)) {
            System.out.println(name + " wins!");
        } else {
                System.out.println("Computer wins!");
        }
    }
}
}