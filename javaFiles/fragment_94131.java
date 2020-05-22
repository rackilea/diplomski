if (doAllFaceUpCardsMatch == false) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        concentration.flipAllCardsFaceDown();
} else {
        concentration.makeAllFaceUpCardsInvisible();
}