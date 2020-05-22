String cards = "";

for(int i = 0; i < 20; i++)
{
    Cards card = new Cards();
    while(cards.contains(card.toString()))
        card = new Cards(); //keep generating a random card until it's a new card
    cards += card.toString(); //add the card to the string of cards
    System.out.println(card);
}