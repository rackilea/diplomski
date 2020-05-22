public Object removeElementBefore(Object o) {
    if (o == null)
        return null;

    Node prev = head;
    Node crt = prev == null ? null : prev.next;
    if (crt == null)
        return null;

    // trying to find the element right before the parameter
    while(crt.next != null && !o.equals(crt.next.content)) {
        prev = prev.next;
        crt = crt.next;
    }

    if (crt.next == null)
        return null;

    // remove crt node from list
    prev.next = crt.next;
    crt.next = null;

    // return the removed content
    return crt.content;
}