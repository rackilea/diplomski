Path path = Paths.get("path/to/file");
byte[] data = Files.readAllBytes(path);

RTFEditorKit rtfParser = new RTFEditorKit();
Document document = rtfParser.createDefaultDocument();
rtfParser.read(new ByteArrayInputStream(data), document, 0);
String text = document.getText(0, document.getLength());