String text = "some content ... \"My name is scott\"  some content ...\n"
        + "\n"
        + "some content ... \"My name is \" +  \n"
        + "    \"scott\"  some content ...";
String textToMatche = "My name is scott";
text = text.replaceAll("\"\\s*\\+\\s*\n\\s*\"", "");// Note the regex : \"\s*\+\s*\n\s*\"