Document document = DocumentHelper.parseText(someXml);
final Comparator<Element> comparator = new Comparator<Element>() {
    public int compare(Element o1, Element o2) {
        return o1.getName().compareTo(o2.getName());
    }
};
Visitor visitor = new VisitorSupport() {
    @Override
    public void visit(Element node) {
        @SuppressWarnings("unchecked") // dom4j doesn't know generics yet
        List<Element> elements = node.elements();
        Collections.sort(elements, comparator);
        super.visit(node);
    }
};
document.accept(visitor);
// now write the document back to a file