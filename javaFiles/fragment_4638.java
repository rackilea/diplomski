String s = "<?xml version=\"1.0\" standalone=\"yes\"?>" +
        "<root>" +
        "</root>" +
        "<?xml version=\"1.0\" standalone=\"yes\"?>" +
        "<root>" +
        "</root>" +
        "<root>" +
        "</root>";

InputStream in = new ByteArrayInputStream(s.getBytes());

int c;
StringBuilder xmlString = new StringBuilder();
List<String> list = new ArrayList<>();
while ((c = in.read()) != -1) {
    xmlString.append((char)c);
    if( (char)c == '>' && xmlString.toString().endsWith(("</root>")) ) {
        list.add(xmlString.toString());
        xmlString = new StringBuilder();
    }
}
in.close();

list.forEach(System.out::println);