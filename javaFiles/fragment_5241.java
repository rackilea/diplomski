String s = "\t\t\tHello I am studying regex!\n\t\t\tThis is a line in the text.\n\t\t\t\tDon't need to add this line\n\t\tnor this line.\n\t\t\tBut this line should be included.";
Pattern pattern = Pattern.compile("(?:\\G(?!^)\\h+|^\t{3})(\\S+)", Pattern.MULTILINE);
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println("Match: '" + matcher.group(1) + "', Start: " + matcher.start(1)); 
}