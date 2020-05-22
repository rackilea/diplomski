void insertElementIntoStructure(Element e, Structure s) {
    if (s.contains(e)) {
        return; // redundant work;
    }
    insert(s, e); // insert the element
}