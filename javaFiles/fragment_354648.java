for(int k=0; k<players; ++k)
    {
        String output = " ";
        for(int i =0; i<cards; i++)
        {
            C = deck.drawFromDeck();
            output+= C.toString() + ",";
        }
        System.out.print("Player " + (k+1) + ": ");
        System.out.println(output);
    }