public void paintScreen() {
    Graphics g;     
    try {           
        g = this.getGraphics();
        if ((g != null) && (DoubleBufferImage != null)) {               
            g.drawImage(DoubleBufferImage, 0, 0, null);         
        }           
        Toolkit.getDefaultToolkit().sync();     
    } catch (Exception e) {         
        System.out.println("Graphics context error: " + e);     
    }   
}