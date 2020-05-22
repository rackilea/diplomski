public static void changecards(int[] cards, boolean[] pack) {
    Scanner read = new Scanner(System.in);
    int cardchange;
    Random give = new Random();
    System.out.println();
    cardchange = -1;
    for (int i = 0; i < 5; i++) {
      System.out.println("\n\nTurn: " + i + " - Enter the card position that you want to change?");
      while (cardchange < 0 || cardchange > 5) {
        System.out.println("Enter a card number between 1 and 5; Enter 0 if you don't want to "
            + "change anything.");
        cardchange = read.nextInt();
      }
      if (cardchange == 0) {
        System.out.println("Turn skipped nothing will be changed.");
      } else {
        System.out.print("Your card number" + cardchange + " will be changed to ");
        cards[cardchange - 1] = give.nextInt(52);
        System.out.println(cards[cardchange - 1]);
      }
      cardchange = -1;
      System.out.println("\n\nYour new cards are : ");
      for (int card : cards) {
        System.out.print(card + "\t");
      }
      findcards(cards,pack);
    }

  }