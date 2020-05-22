JFrame f = new JFrame();
  f.setPreferredSize(new Dimension(600, 600));
  f.pack();
  f.setLayout(new BorderLayout());
  JPanel p = new JPanel(new FlowLayout()) {
     @Override
     protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int perc = (int)((float)getWidth()*0.3f); // set % to fill
        g.setColor(Color.RED);
        g.fillRect(0, 0, perc, g.getClipBounds().height);
        g.setColor(Color.BLUE);
        g.fillRect(perc, 0, getWidth()-perc, getHeight());
     }

  };
  f.add(p);
  p.add(new JButton("test"));
  f.setVisible(true);