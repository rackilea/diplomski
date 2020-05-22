button1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // create new model for the JList
        DefaultListModel<String> listModel = new DefaultListModel<>();
        cards.choseCards(); //Creates an ArrayList with the suffled cards

        // add the cards to the model. I have no idea what your deck field looks like
        // so this is a wild guess.
        for (Card card : cards.deck) {
            listModel.addElement(card.toString());  // do you override toString() for Card? Hope so
        }

        // Guessing that your JList is in a field called displayList.
        displayList.setModel(listModel);  // pass the model in
        cards.cleanUpDeck(); //Removes all the cards from the ArrayList
    }
});