public void printIt(Object1 a) {
    if (null == a) {
        return;
    }

    SubObject b = a.getB();
    if (null == b) {
        return;
    }

    SubObject2 c = b.getC();
    if (null == c) {
        return;
    }

    c.print();
}