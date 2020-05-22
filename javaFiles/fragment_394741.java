Elements elementsByClass = parse.getElementsByClass("drill");
for (Element link : elementsByClass)
{
    List<Node> childNodes = link.childNodes();
    System.out.println("Title: " + childNodes.get(1));
    System.out.println("Result: " + childNodes.get(0).attr("src"));
}