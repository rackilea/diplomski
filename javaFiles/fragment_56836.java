public void searchAndReplace(Map<File, byte[]> fileToContentMap, Map<String, String> wordToDefinitionMap) {

    // for each file
    for (File f : fileToContentMap.keySet()) { 
        // get the file's contents
        String contents = new String(fileToContentMap.get(f));

        // replace the contents with definitions
        for (String word : wordToDefinitionMap.keySet()) {
          contents = contents.replaceAll(word, wordToDefinitionMap.get(word));   
        }

        // make sure to update the contents in the array
        fileToContentMap.put(f, contents.getBytes());

        // note, remember to update the physical file as well

    }
}