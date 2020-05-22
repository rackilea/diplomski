WikiParser p = new WikiParser();
ArrayList<WikiParser.Cm> res = new ArrayList<WikiParser.Cm>();
try {
    p.parseInto(new URL("http://zelda.wikia.com/api.php?action=query&list=categorymembers&cmtitle=Category:Games&cmlimit=500&format=xml"), res);
} catch (MalformedURLException e) {
} catch (IOException e) {
} catch (SAXException e) {}