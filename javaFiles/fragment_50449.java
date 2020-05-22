int i = 0;
while (kids.size() > 1) { // Loop until we have a winner
    wordCount++; // Give the kid a word
    if (wordCount >= words) { // It's the last word, he's out
        rejects.add(kids.remove(i)); // Remove the kid at index i and place it into rejects
        // P.S. Small issue with ArrayList API: If your object type is Integer, then there's ambiguity between remove(T) and remove(int), which will prevent auto boxing from being used
        wordCount = 0; // And from the top
    }
    else {
        i++; // This kid is okay, move to the next
        // P.S. If we removed the kid, we're already pointing at the next one, hence the "else"
    }
    if (i >= kids.size()) { // Reached the end of the kids list
        i = 0; // Loop around
    }
}