List<Character> specialChars = new ArrayList<Character>();
for(char code = 0; code < 256; code++) {
    if(!Character.isLetterOrDigit(code)) {
        specialChars.add(new Character(code));
    }
}