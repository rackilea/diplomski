for (int i = 0; i < words.length - 1; i++) {
    for (int j = i + 1; j < words.length; j++) {
        // Nothing changed below this line...
        int result = words[i].compareTo(words[j]);
        if (result > 0) {
            T temp = words[i];
            words[i] = words[j];
            words[j] = temp;
        }
    }
}