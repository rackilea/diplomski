ArrayList<String> wordsToRemove = new ArrayList<String>();
Set<String> seenWords = new HashSet<String>();

for (String word : userList)
{
    if (!seenWords.add(word))
    {
        wordsToRemove.add(word);
    }
}

for (String word : wordsToRemove)
{
    // Keep removing it until it doesn't exist any more
    while (userList.remove(word)) {}
}