Iterator<String> iterator = links.iterator();
while(iterator.hasNext()) {
    // you need to invoke Iterator.next before manipulating the List
    // or any of its items
    if (!iterator.next().contains("XAB")) {
        iterator.remove();
    }
}