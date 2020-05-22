panou = new javax.swing.JPanel(){
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // Do the original draw
        g.drawLine(10, 10, 60, 60); // Write here your coordinates
    }
};