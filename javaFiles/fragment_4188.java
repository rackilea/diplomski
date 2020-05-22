TreeMap<String, Integer> words = new TreeMap<>();

while ((line = r.readLine()) != null) {
    for (String word : line.split("\\s+")) {
        if (words.containsKey(line))
            words.put(line, words.get(line) + 1);
        else
            words.put(line, 1);  
    }                 
}