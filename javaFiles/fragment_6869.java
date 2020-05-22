String inputFile = "my.html";
String outputFile = "generated.pdf";

String html = new String(Files.readAllBytes(Paths.get(inputFile)));
final Document document = Jsoup.parse(html);
document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);

ITextRenderer renderer = new ITextRenderer();
renderer.setDocumentFromString(document.html());
renderer.layout();

try (OutputStream os = Files.newOutputStream(Paths.get(outputFile))) {
    renderer.createPDF(os);
}