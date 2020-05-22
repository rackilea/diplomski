Iterator<String> iterNames = names.iterator();
if (iterNames.hasNext()) {
    nameList = new listNode(iterNames.next());
    listNode current = nameList;
    while (iter.hasNext()) {
        current.next = new listNode(iterNames.next());
        current = current.next;
    }
}