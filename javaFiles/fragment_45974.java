public static void main(String[] args) throws IOException {
    String html = "<div id=\"d1\">" + //
            "<div id=\"d1.0\">" + //
            "<div id=\"d1.0.0\">" + //
            "1.0.0" + //
            "</div>" + //
            "<div id=\"d1.0.1\">" + //
            "1.0.1" + //
            "</div>" + //
            "</div>" + //
            "<div id=\"d1.1\">" + //
            "1.1" + //
            "</div>" + //
            "<div id=\"d1.3\">" + //
            "1.3" + //
            "</div>" + //
            "</div>";

    List<String> childList = new ArrayList<>();
    NodeVisitor myNodeVisitor = new MyNodeVisitor(childList);
    NodeTraversor traversor = new NodeTraversor(myNodeVisitor);
    Document doc = Jsoup.parse(html);

    Element firstDiv = doc.select("div:first-of-type").first();
    if (firstDiv == null) {
        System.err.println("Unable to find any div.");
    } else {
        traversor.traverse(firstDiv);

        for (String child : childList) {
            System.out.println(child);
        }
    }
}

private static class MyNodeVisitor implements NodeVisitor {

    private List<String> childList;

    public MyNodeVisitor(List<String> childList) {
        if (childList == null) {
            throw new NullPointerException("child cannot be null.");
        }

        this.childList = childList;
    }

    @Override
    public void head(Node node, int depth) {
        if (node.childNodeSize() == 0) {
            childList.add(node.toString());
        }
    }

    @Override
    public void tail(Node node, int depth) {

    }
}