public static void main(String[] args) {
    MyFrame frame = new MyFrame();
    MyPanel panel = new MyPanel();
    frame.add(panel);
    panel.setFocusable(true);
    frame.invalidate();
    frame.validate();
    frame.repaint();

}