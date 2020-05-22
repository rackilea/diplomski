for(int k=0;k<5;k++){

    System.out.print("Hand " + k + ": ");

    for(int j=0;j<4;j++){
        hands[j][k] = myDeck.dealCard(k);
        System.out.print(hands[j][k]);

        if(j != 3) {
            System.out.print(", ");
        }
    }

    System.out.println();
}