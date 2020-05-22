public class BlackjackGameSimulator {

private static Scanner sc = new Scanner(System.in);
private static double gameMoney = 500;
private static double bet;
private static String playOrNot;

public static void main(String[] args)
{
    Deck newDeck = new Deck();
    Deck player = new Deck();
    Deck dealer = new Deck();

    newDeck.setCardDeck();
    newDeck.shuffle();

    while(gameMoney > 0)
    {       
        System.out.println("Would you like to play Blackjack?");
        playOrNot = sc.nextLine();

        if(playOrNot.equalsIgnoreCase("no"))
        {
            System.out.println("Bye! See you next time.");
            break;
        }

        if(playOrNot.equalsIgnoreCase("yes"))
        {
            System.out.println("You have $" + gameMoney + ". How much are you placing your bet?");
            bet = sc.nextDouble();
            sc.nextLine();


            while(bet < 0 || bet > gameMoney)
            {
                System.out.println("Invalid input. Please place your bet between $0 and " + "$" + gameMoney + ".");
                bet = sc.nextDouble();
                sc.nextLine();
            }
        } 

        //Player gets 2 cards in the first round
        player.draw(newDeck);
        player.draw(newDeck);           

        dealer.draw(newDeck);
        dealer.draw(newDeck);

        while(true)
        {
            System.out.println("Your hand: " + player.toString() + "\n");
            System.out.println("Your total points are " + player.cardRank());
            System.out.println();

            if(player.cardRank() == 21)
            {
                winner(player, dealer);
                resetRound(newDeck, player, dealer);
                break;
            }
            else
            {
                //Dealer draws the first card in the current deck
                System.out.println("Dealer hand: " + dealer.dealCard(0).toString() + " and ????");

                System.out.println("Would you like to hit or stand?");
                String reaction = sc.nextLine();

                if(reaction.equalsIgnoreCase("hit"))
                {
                    player.draw(newDeck);
                    System.out.println("You draw " + player.dealCard(player.deckSize() - 1).toString());

                    if(player.cardRank() < 21)
                    {
                        continue;
                    }
                    if(player.cardRank() > 21)
                    {
                        loser(player, dealer);
                        resetRound(newDeck, player, dealer);
                        break;
                    }
                }
            }
            System.out.println("Dealer hand: " + dealer.toString());

            if((dealer.cardRank() > player.cardRank()))
            {
                loser(player, dealer);
                resetRound(newDeck, player, dealer);
                break;
            }

            while((dealer.cardRank() < 17))
            {
                dealer.draw(newDeck);
                System.out.println("Dealer draws " + dealer.dealCard(dealer.deckSize() - 1).toString());
            }
            System.out.println("Dealer's current points are " + dealer.cardRank());

            if((dealer.cardRank() > 21))
            {
                winner(player, dealer);
                resetRound(newDeck, player, dealer);
                break;
            }

            if((player.cardRank() == dealer.cardRank()))
            {
                tie(player, dealer);
                resetRound(newDeck, player, dealer);
                break;
            }

            if((player.cardRank() > dealer.cardRank()))
            {
                winner(player, dealer);
                resetRound(newDeck, player, dealer);
                break;
            }

            if((player.cardRank() < dealer.cardRank()))
            {
                loser(player, dealer);
                resetRound(newDeck, player, dealer);
                break;
            }

            //Return player's and dealer's cards to the deck
            player.resetDeck(newDeck);
            dealer.resetDeck(newDeck);

        }
    }
}

private static void winner(Deck player, Deck dealer)
{
    System.out.println("You win! You current points are " + player.cardRank() + ". Dealer current points are " + dealer.cardRank());
    gameMoney += bet;

}
private static void loser(Deck player, Deck dealer)
{
    System.out.println("You lose! You current points are " + player.cardRank() + ". Dealer current points are " + dealer.cardRank());
    gameMoney -= bet;
}
private static void tie(Deck player, Deck dealer)
{
    System.out.println("Push! It's a tie. You current points are " + player.cardRank() + ". Dealer current points are " + dealer.cardRank());
    gameMoney -= bet;
}
private static void resetRound(Deck newDeck, Deck player, Deck dealer)
{
    player.resetDeck(newDeck);
    dealer.resetDeck(newDeck);
}