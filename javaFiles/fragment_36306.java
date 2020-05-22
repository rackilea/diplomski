private void addStuff() {            
        BufferedImage bi =
            new BufferedImage(100, 100, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics bufferedGraphics = bi.getGraphics();
        //Paint stuff
        bufferedGraphics.drawLine(0, 0, 50, 50);
        javax.swing.JLayeredPane layered;
        layered = new JLayeredPane() {
            @Override
            public void paint(Graphics g) {
                g.drawImage(bi, 0, 0, null);
            }
        };        
        this.add(layered);        
        this.validate();
        this.repaint();
    }