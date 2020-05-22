public class Test2 {

    public static void main(String[] args) {
        Test2 t = new Test2();
        t.createTokens();
        String nextWords = t.getNextWords(5, 30);
        System.out.println("Sentence: " + nextWords);
        String nextWords2 = t.getNextWords(5, 30);
        System.out.println("Sentence: " + nextWords2);
        String nextWords3 = t.getNextWords(5, 30);
        System.out.println("Sentence: " + nextWords3);

        String previousWords = t.getPreviousWords(3, 10);
        System.out.println("Previous Sentence: " + previousWords);
        previousWords = t.getPreviousWords(3, 10);
        System.out.println("Previous Sentence: " + previousWords);
        previousWords = t.getPreviousWords(3, 10);
        System.out.println("Previous Sentence: " + previousWords);
        previousWords = t.getPreviousWords(3, 10);
        System.out.println("Previous Sentence: " + previousWords);
        previousWords = t.getPreviousWords(3, 10);
        System.out.println("Previous Sentence: " + previousWords);

        nextWords = t.getNextWords(5, 30);
        System.out.println("Sentence: " + nextWords);
    }


    static String text = "I am a cat who sat on a mat and yelled as someone who was fat";

    private static List<String> list = new LinkedList<String>();

    // index of the start of the next sentence (i.e also the end of the sentence that is currently being displayed)
    static int nextWordIndex = 0;
    // index of the first word of the current sentence being displayed.
    static int firstWordIndex = 0;

    public void createTokens() {
        String[] splitWords = text.split(" ");
        for (int i = 0; i < splitWords.length; i++) {
            list.add(splitWords[i]);
        }
    }

    public String getPreviousWords(int n, int maxCharacterLength) {
        StringBuilder strBuilder = new StringBuilder();
        int characterCount = 0;
        int itemSize = 0;
        // you need to check this negative or not
        if(firstWordIndex < 0)
            firstWordIndex = 0;
        ListIterator<String> nextIter = list.listIterator(firstWordIndex);
        while (nextIter.hasPrevious() && itemSize < n) {
            String elem = (String) nextIter.previous();
            characterCount += elem.length();
            if (characterCount > maxCharacterLength) {
                break;
            }
            strBuilder.insert(0, elem + " ");
            itemSize++;
        }

        if(firstWordIndex == 0) {
            firstWordIndex = 0;
            nextWordIndex = itemSize;
        }
        nextWordIndex = firstWordIndex;
        firstWordIndex-=itemSize;

        return strBuilder.toString();
    }

    /**
     * Obtains the next n number of words given the maximum number of characters
     * that can fit on the screen. If not all words fit on the screen
     *
     * @param n
     *            number of words
     * @param maxCharacterLength
     *            of text that can fit on the screen.
     * @return next words
     */
    public String getNextWords(int n, int maxCharacterLength) {
        StringBuilder strBuilder = new StringBuilder();
        int characterCount = 0;
        int itemSize = 0;
        ListIterator<String> nextIter = list.listIterator(nextWordIndex);
        while (nextIter.hasNext() && itemSize < n) {
            String elem = (String) nextIter.next();
            characterCount += elem.length();
            if (characterCount > maxCharacterLength) {
                break;
            }
            strBuilder.append(elem);
            strBuilder.append(" ");
            itemSize++;
        }
        firstWordIndex = nextWordIndex;
        nextWordIndex+=itemSize;
        return strBuilder.toString();

    }
}