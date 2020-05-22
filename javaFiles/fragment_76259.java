String keyword = "hello";
String phrase = "goodbye";
for (int i = 0; i < phrase.length(); i++) {
    char p = phrase.charAt(i);
    char k = keyword.charAt(i % keyword.length());
    System.out.println(p + " + " + k + " = " + (char)((p-'a' + k-'a')%26+'a'));
}