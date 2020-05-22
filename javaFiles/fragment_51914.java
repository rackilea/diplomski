String key = sort(inputString);

if (!anagramsBySortedLettersInThem.containsKey(key)) {
  anagramsBySortedLetterInThem.put(key, new HashSet<String>);
} 

anagramsBySortedLettersInThem.get(key).add(inputString);