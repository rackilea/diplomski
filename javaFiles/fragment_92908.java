String translatedWord = null;
int foundIndex = -1;
for (int english = 0; english < spanishWords.length; english++){
    if (textFieldWord.equals(englishWords[english])){
        translatedWord = englishWords[english];
        foundIndex = english;
        break;
    }
}

if (translatedWord != null) {
    translate.setText(translatedWord);
    icon= new ImageIcon(photos[foundIndex]);
    imageviewer.setIcon(icon);
} else {
    translate.setText("That word is not in the Dictionary");
}

translatedWord = null;
for (int spanish = 0; spanish < englishWords.length; spanish++){
    if (textFieldWord.equals(spanishWords[spanish])){
        translatedWord = englishWords[english];
        foundIndex = spanish;
        break;
    }
}   

if (translatedWord != null) {
    translate.setText(translatedWord);
    icontwo= new ImageIcon(photos[foundIndex]);
    imageviewer.setIcon(icontwo);
} else {
    translate.setText("That word is not in the Dictionary");
}