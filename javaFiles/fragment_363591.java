// Load HTML file
String charsetName = "UTF-8";
Document doc = Jsoup.parse(new File("dummy.html"), charsetName);
System.out.println("BEFORE:\n" + doc.outerHtml());

// Replace each link nodes with its respective CSS file content
for (Element link : doc.select("link[rel=stylesheet]")) {
    String cssFilename = link.attr("href");

    Element style = new Element(Tag.valueOf("style"), "");
    style.appendText("/* " + cssFilename + " */");
    style.appendText(loadCssFileContent(cssFilename, charsetName));

    link.replaceWith(style);
}

System.out.println("\nAFTER:\n" + doc.outerHtml());

private static String loadCssFileContent(String path, String charsetName) throws IOException {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, charsetName);
}