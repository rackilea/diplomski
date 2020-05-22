int tokenId = 0;
for (int i = 0; i < tokens.length; i++) {
  if (token[i].equals("/idApp=")) {
    tokenId = i - 1;
    break;
  }
}
String rightToken = tokens[tokenId];