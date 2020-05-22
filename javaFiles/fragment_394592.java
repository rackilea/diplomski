String[] myCards = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
Random rand = new Random();
Scanner scan = new Scanner(System.in);
int cardIndex = rand.nextInt(myCards.length);
ArrayList<String> playerHand = new ArrayList<>();
for (int i = 0; i < 5; i++) {
    while (playerHand.contains(myCards[cardIndex]))
        cardIndex = rand.nextInt(myCards.length);
    playerHand.add(myCards[cardIndex]);
}
System.out.print("Guess the card in my hand: ");
if(playerHand.contains(scan.nextLine()))
    System.out.println("I do have that card in hand");
else
    System.out.println("I do not have that card in hand!");
System.out.print("These were the cards I had in hand: ");
System.out.println(playerHand);