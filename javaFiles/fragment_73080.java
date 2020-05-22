HtmlParser htmlParser = new HtmlParser();
HtmlContentHandler contentHandler = new HtmlContentHandler();
// I presume the `Page page` is present in the scope
InputStream inputStream = new ByteArrayInputStream(page.getContentData());
Metadata metadata = new Metadata();
ParseContext parseContext = new ParseContext();
// and finally parse
htmlParser.parse(inputStream, contentHandler, metadata, parseContext);