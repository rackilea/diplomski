// let's say you have a cardStack containing 52 cards
    ArrayList<String> cardStack = new ArrayList<String>();

    //you can shuffle the cards before dealing
    shuffle(cardStack);

    String[] players = new String[]{"player1", "player2"};

    //this is the loop to deal cards to all players in the array
    for (int i = 0; i < players.length; i++) {

        // if you need to deal 10 cards to each player
        for (int j = 0; j < 10; j++) {
            players[i].addCard(cardStack.get(0));   // assuming your Player Object has an addCard method

            // you will need to remove the card from the cardStack since you gave it to the player
            cardStack.remove(0);                    
        }

    }