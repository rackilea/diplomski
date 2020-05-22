Metadata metadata = new Metadata();
metadata.set(Metadata.RESOURCE_NAME_KEY, filename);
ParseContext context = new ParseContext();

Parser parser = new AutoDetectParser();
parser.parse(input, textHandler, metadata, new ParseContext());

if(metadata.get(CONTENT_TYPE).equals("application/pdf")) {
   // Do something special with the PDF metadata here
}