String content = new Scanner(file).useDelimiter("\\Z").next();
int count = 0;
for (int i = 0; i < content.length(); i++) {
    if (!Character.isWhitespace(content.charAt(i))) {
        count++;
    }
}
System.out.println(count);