List<Element> list = ...
Element current = null;
Element next = null;
Iterator<Element> it = list.iterator();
while (it.hasNext()) {
    current = next;
    next = it.next();
    if (current == null) {
        continue;
    }
    // process 'current' and use `next` when you need to refer to 
    // the following on element.
}
if (next != null) {
    // process 'next' as the last element.
}