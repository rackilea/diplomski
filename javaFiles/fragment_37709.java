public static void reset() {
    findPuzzle();
    field = new ArrayList<>(puzzle.length());
    // Clear the existing values
    for (int index = 0; index < fields.length; index++) {
        fields[index].setText(null);
    }
    // Update the new values
    for (int k = 0; k < puzzle.length(); k++) {
        // Get an individual character from the String and make it a String
        // cause it's easier to deal with...
        String character = Character.toString(puzzle.charAt(k));
        fields[k].setText(character);
        field.add(fields[k]);
    }
}