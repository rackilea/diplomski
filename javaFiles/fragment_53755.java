char characterGuessed = choice.charAt(0);
StringBuilder builder = new StringBuilder();
for(int i = 0; i < word.length(); i++) {
    if(word.charAt(i) == characterGuessed) {
      builder.append(characterGuessed);
    } else {
      builder.append(userWord.charAt(i));
    }
}
userWord = builder.toString();