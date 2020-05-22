ByteArrayInputStream inputStream = new ByteArrayInputStream((
        "a line~with a \r and~a \n in it \r\n" +
        "a line with \n\r in~it\r\n").getBytes());

Scanner sMain = new Scanner(inputStream,"UTF-8").useDelimiter("\r\n");
Pattern wordPattern = Pattern.compile("~");
while (sMain.hasNext()) {
    String line = sMain.next();
    line = line.replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n");
    String[] words = wordPattern.split(line);
    System.out.println(Arrays.toString(words));
}