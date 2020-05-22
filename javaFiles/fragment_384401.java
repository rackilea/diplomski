File file = new File("src/main/resources/unicode.msg");
AutoDetectParser parser = new AutoDetectParser();
BodyContentHandler handler = new BodyContentHandler();
Metadata tikaMetadata = new Metadata();
InputStream input = TikaInputStream.get(file, tikaMetadata);
parser.parse(input, handler, tikaMetadata, new ParseContext());
String messageFrom = tikaMetadata.MESSAGE_FROM;
String fromField = tikaMetadata.get(messageFrom);
System.out.println(fromField);