BreakIterator boundary = BreakIterator.getCharacterInstance(Locale.WHATEVER);
boundary.setText(yourString);
for (int start = boundary.first(), end = boundary.next();
        end != BreakIterator.DONE;
        start = end, end = boundary.next()) {
    String chunk = yourString.substring(start, end);
}