public static Player createPlayerFromConsole() {
    Scanner input = new Scanner(System.in);

    System.out.println("Enter your character's name.");
    String name = input.nextLine();

    System.out.println("Enter your character's stamina.");
    int stamina = input.nextInt();

    System.out.println("Enter your character's defense.");
    int defense = input.nextInt();

    System.out.println("Enter your character's strength.");
    int strength = input.nextInt();

    System.out.println("Enter your character's agility.");
    int agility = input.nextInt();

    System.out.println("Enter your character's intellect.");
    int intellect = input.nextInt();

    return new Player(name, stamina, defense, strength, agility, intellect);
}