private static final Pattern pattern = Pattern.compile("(\\w+)([:!])(\\p{Punct}?)(.*?)(\\p{Punct}?)(?=$|,)");
private static void processUserSearch(String searchText) {
    if (!searchText.isEmpty() && searchText != null) {
    //if (!Util.isEmptyOrNull(searchText) && !Util.isEmptyOrNull(searchPattern)) {
        Matcher matcher = pattern.matcher(searchText);
        while(matcher.find()) {
            System.out.println(searchText + "\n[matcher-count]: " + matcher.groupCount());
            System.out.print("found: ");
            for (int x = 1; x <= matcher.groupCount(); x++) {
                System.out.print("(" + matcher.group(x) + ") ");
            }
            System.out.println("\n");
        }
    }
}