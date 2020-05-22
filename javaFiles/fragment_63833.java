String S = "Username 'user1' Username2 'user2 user21' Usermane3 'user3'";
String[] tokens = S.split("'");//use delimiter as ' to get the value inside the quote
String[] usernames = new String[tokens.length / 2];
for (int i = 1, k = 0; i < tokens.length; i += 2) {
    System.out.println(tokens[i]);
    usernames[k++] = tokens[i];
}