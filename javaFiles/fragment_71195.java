if(prefix.length()>1) {
    prefixlow=prefix.toLowerCase();
    int n = Collections.binarySearch(words, prefixlow);
    if (n < 0 && -n <= words.size()) {
        String firstMatch = words.get(-n - 1);
        int i = -n - 1;
        String match = null;
        while (i < words.size() && (match = words.get(i)).startsWith(prefixlow)) {
            // A completion is found
            completion = match.substring(prefix.length());
            keyboardwindow.jTextArea1.setText(prefix+completion);
            i++;
        }
    } else {
        keyboardwindow.jTextArea1.setText(prefix);
    }
}