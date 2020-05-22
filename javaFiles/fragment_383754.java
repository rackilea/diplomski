/**
 * @param args the command line arguments
 */
public static void main(String[] args) throws IOException {
    // TODO code application logic here
    Document doc = Jsoup.parse(new File("**//HTML File Path//**"), "utf-8");
    Elements elements = doc.getElementsContainingOwnText("**//Text to Search//**");
    for(Element element : elements) {
        Element table = getImmediateParentTable(element);
        System.out.println(table.outerHtml());
    }
}

public static Element getImmediateParentTable(Element element) {
    while(element.tagName().equals("table")) {
        return element;
    }
    return getImmediateParentTable(element.parent());
}