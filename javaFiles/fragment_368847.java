for (Iterator<String> iterator = myString .iterator(); iterator.hasNext();) {
    String string = iterator.next();
    if (string.equals("NEW ROW")) {
        // Call iterator.remove() x times,
        // or until the list runs out of elements
        for (int i = 0 ; iterator.hasNext() && i != x ; i++) {
            iterator.remove();
        }
    }
}