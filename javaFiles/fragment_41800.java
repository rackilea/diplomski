Graphics2D g2 = image.createGraphics();
        g2.setColor(Color.white);
        g2.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
        JLabel jl = new JLabel();
        jl.setForeground(new Color(0, 0, 0));
        icon.paintIcon(jl, g2, 0, 0);
        // at this point the image is created, you could also save it with ImageIO

        // now draw it to the screen
        Graphics g = this.drawingArea.getGraphics();
        g.drawImage(image,0,0,null);