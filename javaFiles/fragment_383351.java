public class DrawingPanel extends JPanel {

    int x = 50;
    int y = 50;

    public DrawingPanel() {
        Timer timer = new Timer(40, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                x += 5;
                y += 5;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(x, y, 10, 10);
    }
}