PrintStream out =
    new PrintStream(new File("stuff.txt"));
while (in.hasNext()) {
    String word = in.next();
    out.println(convert(word));
}