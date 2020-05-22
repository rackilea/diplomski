private static void markBoundaries(String target, BreakIterator iterator) {
    StringBuffer markers = new StringBuffer();
    markers.setLength(target.length() + 1);
    for (int k = 0; k < markers.length(); k++) {
        markers.setCharAt(k, ' ');
    }
    int count = 0;
    iterator.setText(target);
    int boundary = iterator.first();
    while (boundary != BreakIterator.DONE) {
        markers.setCharAt(boundary, '^');
        ++count;
        boundary = iterator.next();
    }
    System.out.println(target);
    System.out.println(markers);
    System.out.println("Number of Boundaries: " + count);
    System.out.println("Number of Sentences: " + (count-1));
}

public static void main(String[] args) {
    Locale currentLocale = new Locale("en", "US");
    BreakIterator sentenceIterator
            = BreakIterator.getSentenceInstance(currentLocale);
    String someText = "He name is Walton D.C. and he just completed his B.Tech last year.";
    markBoundaries(someText, sentenceIterator);
    someText = "This order was placed for QT3000! MK?";
    markBoundaries(someText, sentenceIterator);

}