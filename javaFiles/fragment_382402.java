Set<String> wordsToRemove = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
Set<String> seenWords = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);

for (String word : userList)
{
    if (!seenWords.add(word))
    {
        wordsToRemove.add(word);
    }
}

// Now we know the words we don't want, step through the list again and
// remove them (case-insensitively, as wordsToRemove is case-insensitive)
for (Iterator<String> iterator = userList.iterator(); it.hasNext() ;)
{
    if (wordsToRemove.contains(word))
    {
        iterator.remove();
    }
}