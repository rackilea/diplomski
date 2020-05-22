public void blah()  {
    Node p = first;
    while (p.link != null) {
        p = p.link;
    }
    p.link = first;
}