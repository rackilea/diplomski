@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);  // Effectively clears the BG
        Graphics2D g2d = (Graphics2D)g;
        if(width > 64){
            g2d.drawRect(x,y,width,height);
            x += 1;
            y += 1;
            width -= 1;
            height -= 1;
        }
        // Toolkit.getDefaultToolkit().sync(); 
        // g2d.dispose();  NO!  Don't dispose of this graphics instance
    }