String main = "hi how are you? i am fine.";
// Extract all the words whose length is > 1 and remove duplicates
Set<String> mainWords = new HashSet<>();
for (String s : main.split("\\W")) {
    if (s.length() > 1) {
        mainWords.add(s);
    }
}
String string1 = "hi people what is the need................ how to ................... do the needful.................................. and you can only need the change......................................... in the fine situation................................................. to do the task................... i am alright............... are you okay?";

Set<String> mainWordsToFind = new HashSet<>(mainWords);
// Iterate over all the words and remove the word from the list to find
for (String word : string1.split("\\W")) {
    if (word.length() > 1) {
        mainWordsToFind.remove(word);
    }
}

// Print the percent of word found
System.out.println((double) (mainWords.size() - mainWordsToFind.size()) / mainWords.size());