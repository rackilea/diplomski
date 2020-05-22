Scanner in = new Scanner(System.in);

int NUM_PLAYERS = 5;

ArrayList<Player> players = new ArrayList<Player>();

for (int i = 0; i < NUM_PLAYERS; i++) {
    Player p = new Player();

    System.out.print("Surname: ");
    String surname = in.nextLine();

    System.out.print("Firstname: ");
    String fname = in.nextLine();

    System.out.print("Age: ");
    int age = in.nextInt();

    System.out.print("Height: ");
    int height = in.nextInt();

    System.out.print("Rank: ");
    int rank = in.nextInt();

    p.setSurname(surname);
    p.setFirstName(fname);
    p.setAge(age);
    p.setHeight(height);
    p.setRank(rank);

    System.out.println("Current Player \n" + p);
    players.add(p);
    in.nextLine(); // clear the buffer
}

System.out.println("All players");
System.out.println(players);