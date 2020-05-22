String inputFile = "my.xhtml";
String outputFile = "generated.pdf";

String url = new File(inputFile).toURI().toURL().toString();

ITextRenderer renderer = new ITextRenderer();
renderer.setDocument(url);
renderer.layout();

try (OutputStream os = Files.newOutputStream(Paths.get(outputFile))) {
    renderer.createPDF(os);
}