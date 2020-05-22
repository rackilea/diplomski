ArrayList<Character> chars = new ArrayList<Character>(word.length());
for ( char c : word.toCharArray() ) {
   chars.add(c);
}
Collections.shuffle(chars);
char[] shuffled = new char[chars.size()];
for ( int i = 0; i < shuffled.length; i++ ) {
   shuffled[i] = chars.get(i);
}
String shuffledWord = new String(shuffled);