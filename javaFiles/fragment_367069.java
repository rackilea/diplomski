public void search() {
    hilit.removeAllHighlights();
    for (String s : keywords) {
        String content = textArea.getText();
        Pattern p = Pattern.compile("\\b"+s+"\\b");

        Matcher m = p.matcher(content);
        while (m.find()) {
            int index = m.start();
            int end = index + s.length();
            try {
                hilit.addHighlight(index, end, painter);
            } catch (BadLocationException ex) {
            }

        }
    }

}