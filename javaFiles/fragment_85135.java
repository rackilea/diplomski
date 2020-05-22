WikiParser p = new WikiParser();
ArrayList<String> titles = new ArrayList<String>();
try {
    p.parseInto(new URL("http://zelda.wikia.com/api.php?action=query&list=categorymembers&cmtitle=Category:Games&cmlimit=500&format=xml"), titles);
} catch (MalformedURLException e) {
} catch (IOException e) {
} catch (SAXException e) {}