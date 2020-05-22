JFrame f = new JFrame();
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.add(new JPanel(){

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(10, 10);
        g2d.translate(-1875, -100);
        g2d.setColor(Color.green);
        g2d.draw(lineOK);
        g2d.setColor(Color.green.darker());
        g2d.drawRect(endPointCPOK.x, endPointCPOK.y, 1, 1);
        g2d.setColor(Color.red);
        g2d.draw(lineFAIL);
        g2d.setColor(Color.red.darker());
        g2d.drawRect(endPointCPFAIL.x, endPointCPFAIL.y, 1, 1);
    }
});
f.pack();
f.setSize(450, 500);
f.setLocationRelativeTo(null);
f.setVisible(true);