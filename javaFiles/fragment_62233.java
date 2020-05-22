public void paintComponent(Graphics g){
        super.paintComponent(g);
        Color c = Color.cyan;
        g.setColor(c);
        g.fillRect(0, 0,getWidth(), getHeight());
        add(b);
        repaint();
    }