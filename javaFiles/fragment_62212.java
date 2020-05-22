Set<String> whiteList = new HashSet<String>();
whiteList.add("SW");
whiteList.add("NW");
// ...
for (String word : phrase.split()) {
    if (!whiteList.contains(word)) {
        makeProper(word);
    }
}