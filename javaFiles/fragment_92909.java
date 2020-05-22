String translatedWord = null;
for (int english = 0; english < spanishWords.length; english++){
    if (textFieldWord.equals(englishWords[english])){
        translatedWord = spanishWords[english];
        translate.setText(translatedWord);
        icon= new ImageIcon(photos[english]);
        imageviewer.setIcon(icon);
        break;
    }
}

if (translatedWord == null) {
    translate.setText("That word is not in the Dictionary");
}

translatedWord = null;
for (int spanish = 0; spanish < englishWords.length; spanish++){
    if (textFieldWord.equals(spanishWords[spanish])){
        translatedWord = englishWords[spanish];
        translate.setText(translatedWord);
        icontwo= new ImageIcon(photos[spanish]);
        imageviewer.setIcon(icontwo);
        break;
    }
}   

if (translatedWord == null) {
    translate.setText("That word is not in the Dictionary");
}