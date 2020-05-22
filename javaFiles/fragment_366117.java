public static List<CharSequence> getLines(TextView view) {
    final List<CharSequence> lines = new ArrayList<>();
    final Layout layout = view.getLayout();

    if (layout != null) {
        // Get the number of lines currently in the layout
        final int lineCount = layout.getLineCount();

        // Get the text from the layout.
        final CharSequence text = layout.getText();

        // Initialize a start index of 0, and iterate for all lines
        for (int i = 0, startIndex = 0; i < lineCount; i++) {
            // Get the end index of the current line (use getLineVisibleEnd()
            // instead if you don't want to include whitespace)
            final int endIndex = layout.getLineEnd(i);

            // Add the subSequence between the last start index
            // and the end index for the current line.
            lines.add(text.subSequence(startIndex, endIndex));

            // Update the start index, since the indices are relative
            // to the full text.
            startIndex = endIndex;
        }
    }
    return lines;
}