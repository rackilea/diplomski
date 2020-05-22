public static int getCardValue(String card) {
    for (int s = 0; s != cardSuits.length; s++){
        for (int r = 0; r != cardRanks.length; r++) {
            String GeneratedCard = cardRanks[r] + " " + cardSuits[s];
            if ((GeneratedCard).equals(card)) {
                if (r >= 0 && r <= 8)
                    return r;// handling if condition
                else if (r >= 8 && r <= 12)
                    return 10;// returning value else if condition
            }else{
                return 0;// returning value else condition
            }
        }
    }
    return 0;// returning value FOR loop condition
}