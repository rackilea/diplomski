public static void searchIndex(String searchString) throws IOException, ParseException {
    searchString = searchString.trim();
    if (searchString.length < 1)
        return;
    String[] words = searchString.split(" ");
    if (words.length > 1) {
        for (String word : words)
            searchIndex(word);
    } else {
          // Do normal stuff here
    }
}