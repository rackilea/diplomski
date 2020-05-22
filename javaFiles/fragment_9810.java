//in class definition:
static final boolean[] vowels = new byte['u'+1];
static {
    vowels['a'] = vowels['A'] = vowels['e'] = vowels['E'] = ..... = true;
}

boolean startWithVowel(String word) {
    int index = word.chartAt(0);
    return index<='u' && vowels[index]);
}