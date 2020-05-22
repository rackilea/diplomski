for (Iterator<String> it = streams.iterator(); it.hasNext();) {
    String word = it.next();
    for (String sw : stopWords) {
        if (word.equals(sw)) {
            it.remove();
            break;
        }
    }
}