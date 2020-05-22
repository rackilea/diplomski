// Pass 1 -- find all duplicate words
    Set<String> wordSet = new HashSet<>();
    Set<String> duplicateSet = new HashSet<>();
    for (int i = 0; i < array.length; i++) {
        String[] parts = array[i].split(" ");
        for (String part : parts) {
            if (!wordSet.contains(part)) {
                // Haven't seen this word before
                wordSet.add(part);
            } else {
                // This word is a duplicate word
                if (!duplicateSet.contains(part)) {
                    duplicateSet.add(part);
                }
            }
        }
    }

    // Pass 2 -- remove all words that are in the duplicate set
    for (int i = 0; i < array.length; i++) {
        String[] parts = array[i].split(" ");
        String dedupedString = "";
        for (String part : parts) {
            if (!duplicateSet.contains(part)) {
                dedupedString += part + " ";
            }
        }
        array[i] = dedupedString;
    }