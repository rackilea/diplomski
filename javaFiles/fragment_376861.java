public static Map<String, List<WordOccurrence>> createOccurrencesMap(String text) {
        text = text.replaceAll("\\.", " ");
//      text = text.replaceAll("'s", ""); // dog's != dog ???
        Map<String, List<WordOccurrence>> result = new HashMap<>();
        String[] lines = text.split("\n");
        for (int i = 0; i < lines.length; i++)
            for (String word : lines[i].split("\\s+")) 
                result.computeIfAbsent(word, w -> new ArrayList<>())
                            .add(new WordOccurrence(word, i + 1));

        return result;
    }