private String[] findRing(String... words) {
    for (int i = 0; i < words.length; i++) {
        String word = words[i];
        String[] result = findRingForHeadAndTail(word, dropElementWithIndex(i, words));
        if ((result.length == words.length - 1) &&
                (word.charAt(0) == result[result.length - 1].charAt(result[result.length - 1].length() - 1))) { //word started from last letter in tail
            return concatHeadAndTail(word, result);
        }
    }
    return new String[]{"NO SOLUTION"};
}

private String[] findRingForHeadAndTail(
        String head, //first word
        String... tail //other words
) {
    if (tail.length == 0) { // if we don't have other words then just return empty array
        return new String[0];
    }

    if (tail.length == 1) { // if we have just one word in tail
        if (tail[0].charAt(0) == head.charAt(head.length() - 1)) { //and this word begins with last letter in head
            return tail; //return this tail
        } else {
            return new String[0]; //otherwise return empty array
        }
    }

    for (int i = 0; i < tail.length; i++) { // for every word
        String word = tail[i];
        if (word.charAt(0) == head.charAt(head.length() - 1)) { // if this word begins with last letter in head
            String[] result = findRingForHeadAndTail( //recursive call for 
                    word, //picked word
                    dropElementWithIndex(i, tail) // all other words in tail
            ); 
            if (result.length == tail.length - 1) { // if recursive call returns the same amount of words as we passed there as tail
                return concatHeadAndTail(word, result); //return array {head, tail}
            }
        }
    }
    return new String[0];
}

//returns array as {head, tail}
private String[] concatHeadAndTail(String head, String... tail) {
    return Stream.concat(Stream.of(head), Stream.of(tail)).collect(Collectors.toList()).toArray(new String[tail.length + 1]);
}

//removes element with index i from words
private String[] dropElementWithIndex(int i, String... words) {
    List<String> result = new ArrayList<>();
    for (int j = 0; j < words.length; j++) {
        if (j != i) {
            result.add(words[j]);
        }
    }
    return result.toArray(new String[words.length - 1]);
}