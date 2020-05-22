int[] letters = new int[26];
for (int i = 0; i < s.length(); i++) {
    letters[s.charAt(i) - 97]++;
}
char[] copyLoop = new char[26];

for (int i = 0; i < letters.length; i++) {
    if (letters[i] > 1) {
        char c = (char) (i + 97);
        copyLoop[i] = c;            
    }
}
return copyLoop;