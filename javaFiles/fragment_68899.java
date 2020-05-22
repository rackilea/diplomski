int charCount =0;
for(int i=0; i<sentence.length(); i++) {
    if(!Character.isWhitespace(sentence.charAt(i))) {
        charCount++;
    }
}