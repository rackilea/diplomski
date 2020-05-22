static String[] places = {"Man Utd", "Arsenal", "Aston Villa", "Chelsea", 
        "Everton", "Fulham", "Liverpool", "Man City", "Newcastle", "Norwich",
        "QPR", "Reading", "Southampton", "Stoke", "Sunderland", "Swansea", 
        "Spurs", "West Brom", "West ham", "Wigan"};
static int[] NA = new ArrayList<Integer>(5);
static Random rand = new Random();
static int RandInt = 0;
static int player = 1;

public static void main(String[] args) {
  while (player < 5) {
    RandInt = rand.nextInt(places.length);

    for (int i = 0; i <= NA.size(); i++) {
      if (RandInt == NA.get(i)) {
        RandInt = rand.nextInt(places.length);
      } else {
        NA.add(RandInt);
        break;
      }
    }
    System.out.println("player " + player + " is managing " + places[RandInt]);
    player++;
  }
  System.exit(0);
}