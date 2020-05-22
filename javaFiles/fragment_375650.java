List<String> games = new ArrayList<>();
String game;
Scanner in = new Scanner(System.in);
while ((game = in.nextLine()) != null) {
  if (game.equals("quit")) {
    // process 'games' however you want, for example
    for (String g : games) {
      System.out.println(g);
    }
  } else {
    games.add(game);
  }
}