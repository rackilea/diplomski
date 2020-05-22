static String removeDuplicates(String string) {

    String noDuplicates = new String("");

    for (int i = 0; i < string.length(); i++) {

        if (!noDuplicates.contains("" + string.charAt(i))) {
            noDuplicates += "" + string.charAt(i);
        }
    }

    return noDuplicates;
}