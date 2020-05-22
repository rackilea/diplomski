String sb = "have anic eday";
String[] words = sb.split("\\s"); //you need to use BACKWARDSLASH "\\s" to get it to work.
StringBuilder sbFinal = new StringBuilder();


for (int i = 0; i < words[0].length(); i++) {
    for (int j = 0; j < words.length; j++) {
        sbFinal.append(words[j].charAt(i));
    }
    sbFinal.append(" ");
}

System.out.println(sbFinal.toString());