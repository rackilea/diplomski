private static void printCross(String w1, int pos1, String w2, int pos2) {
    // you can replace this for-loop with the line that follows it
    // if you don't get compiler errors
    String spaces = "";
    for (int i=0; i < pos1; ++i) spaces += " ";
    //String spaces = String.format(String.format("%%0%dd", pos1), 0).replace("0", " ");

    for (int i=0; i < w2.length(); ++i) {
        if (i == pos2) {
            System.out.println(w1);
        }
        else {
            System.out.println(spaces + w2.charAt(i));
        }
    }
}