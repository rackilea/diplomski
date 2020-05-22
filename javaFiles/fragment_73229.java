// Change this initialization to Set instead of ArrayList
private Set<Integer> userLotteryPicks = new HashSet<Integer>(5);

public void getUserPicks() {
  Scanner keyboard = new Scanner(System.in);
  int userPicks = 0;
  System.out.println("Enter your 5 lucky numbers for the lottery: ");
  for (int i = 0; i < 5; i++) {
    userPicks = keyboard.nextInt();

    boolean unique = false;
    if (userPicks < 10 && userPicks > 0) {
      unique = userLotteryPicks.add(userPicks);   //if duplicate, then it return false.
    } else {
      System.out.println("Not a valid entry. "
          + "Make sure the number is between 1-9.");
      i--;  // for wrong inputs, decrease the counter by again, instead of start over again.
      continue;
    }
    if (!unique) {
      System.out.println("You put an invalid entry. No duplicates allowed. Enter the number again.");
      i--;  // for wrong inputs, decrease the counter by again, instead of start over again.
    }
  }
}