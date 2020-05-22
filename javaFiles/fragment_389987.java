private static Deck initialDraw(Deck deck, Hand player, Hand dealer)

    {
        deck = drawFromDeck(deck, player);
        deck = drawFromDeck(deck, dealer);
        deck = drawFromDeck(deck, player);
        deck = drawFromDeck(deck, dealer);

        System.out.print("\n");

        showHands(player, dealer);
        compareHands(player, dealer);

        return deck;
    }