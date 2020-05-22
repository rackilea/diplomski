char firstCharacter = 'a';
char lastCharacter = 'z';
int[] frequency = new int[lastCharacter - firstCharacter + 1];
for (char c : characters) {
  frequency[c - firstCharacter]++;
}