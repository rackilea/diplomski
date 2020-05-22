String keyWord = "key word";
String input = "some\ntext\nkey word is here\nand more text\nto follow";
int pos = input.indexOf(keyWord);
if (pos != -1) {
    String trimmed = input.substring(0, pos + keyWord.length());
    System.err.println("'" + trimmed + "'");
}