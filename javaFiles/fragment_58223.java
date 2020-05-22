public void paint(Graphics g) {
    StringBuilder sb = new StringBuilder(27);

    if (pickA) {
        sb.append("a ");
    }
    if (pickB) {
        sb.append("b ");
    }
    // ... remainder cases ...

    g.drawString(sb.toString(), 10, 10);
}