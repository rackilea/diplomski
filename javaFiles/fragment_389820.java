public class GameCanvas extends JPanel {

    public GameCanvas() {
        // Pointless
        //setDoubleBuffered(true);
        JLabel goal = new JLabel();
        goal.setText("|=========|");
        goal.setForeground(Color.WHITE);
        goal.setFont(new Font("Seif", Font.PLAIN, 20));
        this.add(goal);
        // Pointless
        //goal.setBounds(325, -10, 600, 50);

        // Pointless
        //this.getPreferredSize();
        // Pointless
        //this.setVisible(true);
        // Pointless
        //this.repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    @Override
    public void paintComponent(Graphics g) {

        int firstRoad = 5;
        int i = 0;
        int max = 10;

        Graphics2D g2 = (Graphics2D) g;

        super.paintComponent(g2);
        g2.setColor(Color.WHITE);
        g2.drawRect(5, 30, 75, 40);

        while (i < max) {
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(3));

            if (i % 2 == 0) {
                g.setColor(Color.WHITE);
                g.drawRect(3, firstRoad + 50 * i, 793, 50);
                //g.fillRect(3, firstRoad + 50 * i, 793, 50);
            } else {
                g2.setColor(Color.WHITE);
                g2.drawRect(3, firstRoad + 50 * i, 793, 50);
            }
            i++;
        }
    }
}