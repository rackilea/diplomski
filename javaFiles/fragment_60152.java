/**
 * Parse a String sequence of:
 *   {word1, w1_x1, w1_y1, w1_x2, w1_y2, word2, w2_x1, ...}
 *   
 * Into a sequence of Rectangles.
 * 
 * @param wordList Word list sequence to parse
 * @return A List of Rectangles
 */
private List<Rectangle> parseWordBounds(List<String> wordList) {
    List<Rectangle> wordBounds = new LinkedList<Rectangle>();
    Iterator<String> wordListIterator = wordList.iterator();
    while(wordListIterator.hasNext()) {
        // sequences are: {word, x1, y1, x2, y2}  
        wordListIterator.next(); // skip the word
        int x1 = (int) Float.parseFloat(wordListIterator.next());
        int y1 = (int) Float.parseFloat(wordListIterator.next());
        int x2 = (int) Float.parseFloat(wordListIterator.next());
        int y2 = (int) Float.parseFloat(wordListIterator.next());
        wordBounds.add(new Rectangle(x1, y2, x2 - x1, y1 - y2)); // in page, not screen coordinates
    }
    return wordBounds;
}