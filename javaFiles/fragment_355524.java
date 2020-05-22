Scanner inputFile = new Scanner(new File("C:/Test/test.txt"));
   Map<String, Integer> counts = new HashMap<>();
    while (inputFile.hasNextLine()) {
        String line = inputFile.nextLine();         
        for (String word : line.split(" ")) {
            Integer count = counts.get(word);
            counts.put(word, count == null ? 1 : count + 1);
        }

    }
    System.out.println(counts);