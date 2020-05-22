nameList = null;
listNode current = null;
for (String person : names) {
    if (nameList= null) {
        nameList = new listNode(names.get(0));
        current = nameList;
    } else {
        current.next = new listNode(person);
        current = current.next;
    }
}