public void paint(Graphics g) {
    g.setBackgroundColor(Color.GRAY);
    // calling clear makes the background gray
    g.clear();

    // now draw some text
    g.setColor(Color.WHITE);
    g.drawText("hello", 20, 40);
}