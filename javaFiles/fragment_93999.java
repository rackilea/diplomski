Node current = top;
boolean found = false;
boolean added = false;
while (!(found || added)) {
    if (current matches word) {
        increment current.count and move to top of list;
        found = true;
    } else if (current.getLink() == null) {
        make new node using word, count 1, link null;
        current.setLink(new node);
        added = true;
    } else {
        current = current.getLink();
    }
}