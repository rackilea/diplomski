String text = "";

for (int i = 0; i < WORD.length(); i++) {
    if (String.valueOf(word.charAt(i)).equals(letter)) {
        text += letter + " ";
    } else {
        text += "? ";
    }
}

input.setText(text);