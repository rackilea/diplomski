InputStream input = new FileInputStream(new File(resourceLocation));
ContentHandler textHandler = new BodyContentHandler();
Metadata metadata = new Metadata();
PDFParser parser = new PDFParser();
parser.parse(input, textHandler, metadata);
input.close();
out.println("Title: " + metadata.get("title"));
out.println("Author: " + metadata.get("Author"));
out.println("content: " + textHandler.toString());