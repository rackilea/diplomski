String S = "Username 'user1' Username2 'user2' Usermane3 'user3' 'user4'";
ArrayList<String> words = new ArrayList();
String word = "";
boolean startQuote = false;
for (int i = 0; i < S.length(); ++i) {
    char ch = S.charAt(i);
    if (ch == '\'') {
        if (word.equals(""))
            startQuote = true;
        else {
            words.add(word);
            word = "";
            startQuote = false;
            }
        }
    else if (startQuote) {
        word += ch;
    }
}
System.out.println(words);