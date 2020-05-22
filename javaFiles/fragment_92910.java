public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == getTranslation) {
        textFieldWord = (entry.getText().toLowerCase());

        translate.setText(null);

        String translatedWord = null;
        for (int english = 0; english < spanishWords.length; english++) {
            if (textFieldWord.equals(englishWords[english])) {
                translatedWord = spanishWords[english];
                translate.append(translatedWord + "\n");
                icon = new ImageIcon(photos[english]);
                imageviewer.setIcon(icon);
                break;
            }
        }

        if (translatedWord == null) {

            for (int spanish = 0; spanish < englishWords.length; spanish++) {
                if (textFieldWord.equals(spanishWords[spanish])) {
                    translatedWord = englishWords[spanish];
                    translate.append(translatedWord + "\n");
                icontwo = new ImageIcon(photos[spanish]);
                    imageviewer.setIcon(icontwo);
                    break;
                }
            }

        }

        if (translatedWord == null) {
            translate.append("A Spanish-English match is not in the Dictionary\n");
        }
    }
}