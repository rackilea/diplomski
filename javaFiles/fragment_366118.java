public static List<CharSequence> getLines(TextView view) {
    final List<CharSequence> lines = new ArrayList<>();
    final Layout layout = view.getLayout();

    if (layout != null) {
        final int lineCount = layout.getLineCount();
        final CharSequence text = layout.getText();

        for (int i = 0, startIndex = 0; i < lineCount; i++) {
            final int endIndex = layout.getLineEnd(i);
            lines.add(text.subSequence(startIndex, endIndex));
            startIndex = endIndex;
        }
    }
    return lines;
}