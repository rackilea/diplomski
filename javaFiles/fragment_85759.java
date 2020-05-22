Scanner keyboard = new Scanner(System.in);
double weight;
int choice;

System.out.println("What is your weight in pounds?");
weight = keyboard.nextDouble();

do {
    System.out.println("Which planet would you like to see your weight on?\n 1. Venus   2. Mars 3. Jupiter\n 4. Saturn  5. Uranus   6. Neptune\n 7. Exit");
    choice = keyboard.nextInt();
    switch(choice) {
        case 1:
            System.out.println("Your weight on Venus would be " + (weight * 0.78));
            break;
        case 2:
            System.out.println("Your weight on Mars would be " + (weight * .39));
            break;
        case 3:
            System.out.println("Your weight on Jupiter would be " + (weight * 2.65));
            break;
        case 4:
            System.out.println("Your weight on Saturn would be " + (weight * 1.17));
            break;
        case 5:
            System.out.println("Your weight on Uranus would be" +(weight * 1.05));
            break;
        case 6:
            System.out.println("Your weight on Neptune would be " + (weight * 1.23));
            break;
        case 7:
            System.out.println("Bye");
            break;
        default:
            System.out.println("This was not a choice, try again!");
            break;
    }
} while (choice != 7);