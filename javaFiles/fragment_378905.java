String testString = "(go|add)addition|(sub)subtraction|(mul|into)multiplication|adding(add|go)values|(add|go)(go)(into)multiplication|";
Pattern p = Pattern.compile("((?:\\([^)]*\\))*)([^()|]+(?:\\([^)]*\\)[^()|]*)*)");
Matcher m = p.matcher(testString);
while (m.find()) {
    System.out.println(m.group(2)+m.group(1));
}