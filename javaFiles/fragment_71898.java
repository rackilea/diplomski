int n = 0;
Pattern r = Pattern.compile("(Chapter.*?)<br />");

Matcher m = r.matcher(fileToShow);
while (m.find()) {
    System.out.println("Found value: " + m.group(0));
    fileToShow = fileToShow.replaceAll(m.group(0),"<Chapter "+ ++n +">");
}