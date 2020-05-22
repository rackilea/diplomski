public static void main(String[] args) throws IOException {
    // Read your html into a string
    StringWriter writer = new StringWriter();
    IOUtils.copy(Main.class.getResourceAsStream("/so18644171/html.html"), writer);
    String theString = writer.toString();

    Document doc = Jsoup.parse(theString);

    // a[name^=linkTab] means: 
    // all a's having a attribute name, starting with "linkTab"
    Elements linkTabs = doc.select("a[name^=linkTab] + table");

    // "a[name^=linkTab] + table means: All tables followed by a[...]

    System.out.println(linkTabs);
}