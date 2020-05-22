public void save(Object object, File file) {    

    BufferedWriter writter = null;

    try {
        writter = new BufferedWriter(new FileWriter(file));

        Dictionary dictionary = (Dictionary)object; 
        ArrayList<Card> cardList = dictionary.getCardList();
        for (Card card: cardList) {
            String line = card.getForeignWord() + " / " + card.getNativeWord();
            writter.write(line); // <== I removed the block around this, on
                                 // the assumption that if writing one card fails,
                                 // you want the whole operation to fail. If you
                                 // just want to ignore it, you would put back
                                 // the block.
        }

        writter.flush(); // <== This is unnecessary, `close` will flush
        writter.close();
        writter = null;  // <== null `writter` when done with it, as a flag
    } catch (IOException e) {
        e.printStackTrace(); // <== Usually want to do something more useful with this
    } finally {
        // Handle the case where something failed that you *didn't* catch
        if (writter != null) {
            try {
                writter.close();
                writter = null;
            } catch (Exception e2) {
            }
        }
    }
}