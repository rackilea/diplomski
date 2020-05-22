String[] words = str1.split("[!-~]* ");
Set<String> uniqueWords = new HashSet<String>();

for (String word : words) {
    uniqueWords.add(word);
}