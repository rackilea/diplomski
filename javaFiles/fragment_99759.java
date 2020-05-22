for (int i = 0; i < letters.length; i++) 
{ 
    if (letters[i] > 1) 
    { 
        char c = (char) (i + 97); 
        char[] copyLoop = new char[26]; 
        copyLoop[c]++;
    }
}