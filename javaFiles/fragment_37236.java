Map<Character, Integer> charMap = new HashMap<Character, Integer>();
while((ch=reader.read()) != -1) {
  char key = (char)ch;
  if(charMap.containsKey(key)) {
    int value = charMap.get(key);
    charMap.put(key, value + 1);
  } else {
     charMap.put(key,1);
  }
}