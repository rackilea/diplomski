public static void main(String[] args) throws ParseException, IOException
{
    //I put your HTML in the body tag in a local file
    Document doc = Jsoup.parse(new File("input/20160505.html"), "UTF-8");
    Elements elements = doc.getElementsByTag("body");
    Element rootTag = elements.get(0);
    printTextOfTag(rootTag);
}

public static void printTextOfTag(Element currentTag)
{
    List<Node> nodes = currentTag.childNodes();
    for(Node n : nodes)
    {
        if(n instanceof TextNode)
        {
            System.out.println(((TextNode)n).text());
        }
        else if(n instanceof Element)
        {
            printTextOfTag((Element)n);
        }
    }
}