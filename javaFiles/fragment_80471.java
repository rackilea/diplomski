public String toString() {
    StringBuilder strBuilder = new StringBuilder();

    Node p = first;
    //Node r = first;
    while (p != null) {
        strBuilder.append(p.name).append(" ");
        strBuilder.append(p.score).append("\n");
        p = p.next;
    }
    //while (r != null) {
    //    strBuilder.append(r.score).append("\n");
    //    r = r.next;
    //}
    return strBuilder.toString();
}