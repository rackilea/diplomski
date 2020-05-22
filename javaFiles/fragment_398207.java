if (p1 != null) {
    if (p1 == first) {
        first = first.next;
    } else {
        p2.next = p1.next;
    }
}
return first;