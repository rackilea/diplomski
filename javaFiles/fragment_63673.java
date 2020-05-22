int currentPosition = 0;
List<Card> items = new ArrayList<Card>(mTestDeck).shuffle();

// Call this method once in onCreate or anywhere you initialize the UI
private void function setCurrentCard() {
    Card currentItem = items.get(currentPosition);

    [...] // Set all UI views here

    myButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (currentPosition > items.size) {
                // TODO? End?
                return;
            }

            currentPosition++;
            setCurrentCard();
        }
    });
}