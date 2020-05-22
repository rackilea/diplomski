public static Iterator<Segment> getChildSegments(Element elem) {
    final Iterator<Segment> it = elem.getContent().getNodeIterator();
    final List<Segment> results = new LinkedList<Segment>();
    final List<Element> children = elem.getChildElements();
    while (it.hasNext()) {
        Segment cur = it.next();
        if (cur instanceof CharacterReference)
            results.add(cur);
        else if (cur instanceof Tag) {
            if (cur instanceof StartTag)
                results.add(((StartTag)cur).getElement());
        }
        else {
            for (Element child : children)
                if (child.contains(cur)) continue;
            results.add(cur);
        }
    }
    return results.iterator();
}