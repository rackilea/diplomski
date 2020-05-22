String wordcopy = word;
    int size = wordcopy.length();
    for (int i = 1; i <= size; i += 1) {
        for (int j = 0; j < i; j++) {
            System.out.print(word.substring(0, i));
        }
        System.out.println("");
    }