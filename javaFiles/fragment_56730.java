String fileContents = "this is a test";
        int wordCount = 0;
        for (String word: fileContents.split("\\s+")) {
            System.out.println(word);
            wordCount++;
            System.out.println(wordCount);
        }