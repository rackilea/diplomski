@Override
protected void paintComponent(Graphics g){
    // Create the 2D copy
    Graphics2D g2 = (Graphics2D)g.create();

    // Apply vertical gradient
    g2.setPaint(new GradientPaint(0, 0, Color.WHITE, 0, getHeight(), Color.BLUE));
    g2.fillRect(0, 0, getWidth(), getHeight());

    // Dipose of copy
    g2.dispose();
}