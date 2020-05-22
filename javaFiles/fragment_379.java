String colors[] = { "Red", "Blue", "Green", "Red", "White", "Orange",
                "Green", "White", "Yellow" };
String lookingForColor = "Red";

List<Integer> indexes = new ArrayList<Integer>();

for (int i = 0; i < colors.length; i++) {
    if (colors[i].equals(lookingForColor)) {
        indexes.add(i);
        Log.i("YOURTAG", "item match at: " + i);
    }
}