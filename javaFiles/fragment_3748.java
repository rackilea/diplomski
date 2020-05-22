@Override
protected void paintChildren(Graphics g) {
    super.paintChildren(g);

    // draw some text
    FontMetrics fm = g.getFontMetrics();
    // will be drawn outside panel; under menu
    g.drawString("TEST TOP/LEFT", 0, fm.getAscent());
    final String s = "TEST BOTTOM/RIGHT";
    // will be drawn noticeably above the bottom
    g.drawString(s, getWidth() - fm.stringWidth(s),
        getHeight() - fm.getDescent());
}