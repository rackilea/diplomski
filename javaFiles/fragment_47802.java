public static int convertToPitch(String note) {
  String sym = "";
  int oct = 0;
  String[][] notes = { {"C"}, {"Db", "C#"}, {"D"}, {"Eb", "D#"}, {"E"},
    {"F"}, {"Gb", "F#"}, {"G"}, {"Ab", "G#"}, {"A"}, {"Bb", "A#"}, {"B"} };

  char[] splitNote = note.toCharArray();

  // If the length is two, then grab the symbol and number.
  // Otherwise, it must be a two-char note.
  if (splitNote.length == 2) {
    sym += splitNote[0];
    oct = splitNote[1];
  } else if (splitNote.length == 3) {
    sym += Character.toString(splitNote[0]);
    sym += Character.toString(splitNote[1]);
    oct = splitNote[2];
  }

  // Find the corresponding note in the array.
  for (int i = 0; i < notes.length; i++)
  for (int j = 0; j < notes[i].length; j++) {
    if (notes[i][j].equals(sym)) {
        return Character.getNumericValue(oct) * 12 + i;
    }
  }

  // If nothing was found, we return -1.
  return -1;
}