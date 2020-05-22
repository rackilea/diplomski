int dolzina = -1;
Scanner in = new Scanner(System.in);
do {
    System.out.println("Vnesi dožino besede, ki jo iščeš");
    if (in.hasNextInt()) {
        dolzina = in.nextInt();
    } else if (in.hasNextLine()) {
        System.out.printf("Wrong entry (%s) try again!%n",
                in.nextLine());
    } else {
        System.out.println("No Entry!");
        System.exit(1);
    }
} while (dolzina < 0);