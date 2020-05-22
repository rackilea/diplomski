Node < E > p2 = null;
    Node < E > p1 = first;
    while (p1 != null && x.compareTo(p1.data) != 0) {
        p2 = p1;
        p1 = p1.next;
    }