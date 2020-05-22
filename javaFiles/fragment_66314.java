public String getAtIndex(int part, int index) {
        if (index < 0 || index >= getCharCount()) {
            return null;
        }
        switch (part) {
        case AccessibleText.CHARACTER:
            try {
                return getText(index, 1);
            } catch (BadLocationException e) {
                return null;
            }
        case AccessibleText.WORD:
            try {
                String s = getText(0, getCharCount());
                BreakIterator words = BreakIterator.getWordInstance(getLocale());
                words.setText(s);
                int end = words.following(index);
                return s.substring(words.previous(), end);
            } catch (BadLocationException e) {
                return null;
            }
        case AccessibleText.SENTENCE:
            try {
                String s = getText(0, getCharCount());
                BreakIterator sentence =
                    BreakIterator.getSentenceInstance(getLocale());
                sentence.setText(s);
                int end = sentence.following(index);
                return s.substring(sentence.previous(), end);
            } catch (BadLocationException e) {
                return null;
            }
        default:
            return null;
        }
    }