int[] letter_counts = new int[26]; // how many of each letter of the
                                   // alphabet you have in your 17 letters

boolean test_word(String word)  // pass in the sorted string e.g "ceeehs"
{
    char prev = '\0'; // use this for detecting repeating letters
    int count = 0;
    for(int i = 0; i < word.length(); i++)
    {
        char c = word.charAt(i);
        if(c != prev)
        {
            prev = c;
            count = 0;
        }
        count++;
        if(letter_counts[(int)c - 'a'] < count)
            return false; // not enough letters
    }
    return true;
}