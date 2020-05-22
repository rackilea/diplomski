public static Iterator<Segment> directPlainTextChildren(Element elem) {
    final Iterator<Segment> it = elem.getContent().getNodeIterator();
    final List<Segment> results = new LinkedList<Segment>();
    final List<Element> children = elem.getChildElements();
    while (it.hasNext()) {
        Segment cur = it.next();
        if (!(cur instanceof Tag) && !(cur instanceof CharacterReference)) {
            for (Element child : children)
                if (child.contains(cur)) continue;
            results.add(cur);
        }
    }
    return results.iterator();
}