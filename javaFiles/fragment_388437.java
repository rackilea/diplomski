class MyPanel extends JPanel {

    @override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      //paint what you want here
      g.drawString("Hello world",250,250);
    }
}