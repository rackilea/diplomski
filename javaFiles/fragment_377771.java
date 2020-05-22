ArrayList<Word> wordList = new ArrayList<Word>();
    String fileName, word;
    Scanner reader = null;
    Scanner scanner = new Scanner(System.in);

    try {
        reader = new Scanner(new FileInputStream(fileName));
    }
    catch(FileNotFoundException e) {
        System.out.println("The file could not be found. The program will now exit.");
        System.exit(0);
    }

    while (reader.hasNext()) {
            word = reader.next().toLowerCase();
            boolean wordExists = false;
            for (Word value : wordList) {
               // We have seen the word before so increase frequency.
               if(value.getValue().equals(word)) {
                    value.frequency++;
                    wordExists = true;
                    break;
               }
            }
            // This is the first time we have seen the word!
            if (!wordExists) {
                Word newValue = new Word(word);
                newValue.frequency = 1;
                wordList.add(newValue);
             }
        }
}