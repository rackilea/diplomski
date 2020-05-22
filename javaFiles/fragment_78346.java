String[] argi = {"http://www.google.com", "http://www.youtube.com"};
String str = "";

if (word == null || word.isEmpty()) {
    str = "Enter a search word!";
} 
else if(!word.matches("^\\w+$")) {
    str = "Incorrect word!";
}
else {
    for (int i = 0; i < argi.length; i++) {
        String result = search(argi[i], "\\b" + word + "\\b");
        if (result != null) {
            str += "Search word <b>" + word + "</b> have been found in "
                + "<a href=\"" + argi[i] + "\">" + result + "</a><br>";
        }
    }
    if (str.isEmpty()) {
        str = "Word not found!";
    }
}