Scanner src = new Scanner(is);
while (src.hasNext()) {

    int line = src.nextInt();
    String value = src.next();

    LineOfText lot = new LineOfText(line, value);

}