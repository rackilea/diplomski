private void addWordsFromFile(FileResource resource, String fileName) {
    for(String word : resource.words()){
        word = word.toLowerCase();

        //Make sure key exists and ArrayList is initialized:
        if (!mapWords.containsKey(word)){
            mapWords.put(word, new ArrayList<String>());
        }

        //Add filename to word's ArrayList if filename wasn't added before:
        if (!mapWords.get(word).contains(fileName)) {
            mapWords.get(word).add(fileName);
        }
    }
}