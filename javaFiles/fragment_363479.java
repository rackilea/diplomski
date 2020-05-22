String inputLine = "+foo 3+4 foofoo foo foo @bar.com +foofoofoo +foo1 +foo2 +foo3";
Pattern re = Pattern.compile("(\\s|^)\\+(\\w+)");
Matcher m = re.matcher(inputLine);
while (m.find()) {
    System.out.println(m.group(2));
}