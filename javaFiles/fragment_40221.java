public class GroundTruthMarker extends JPanel {

    private BufferedImage img = null;  // ADD THIS LINE
    [...]
    private void initialize() {
        [...]
        // JLabel lblpicture = new JLabel("");  // REMOVE THIS LINE
        // ADD THE FOLLOWING INSTEAD
        JPanel lblpicture = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img,0,0,null);
                g.setColor(Color.cyan);
                g.drawLine(leftSide.x, leftSide.y, rightSide.x, rightSide.y);
            }
        };
        [...]
        public void mouseClicked(MouseEvent e) {
            [...]
            // REMOVE THIS!
            //Graphics g = getGraphics();
            //g.setColor(Color.cyan);
            //g.drawLine(leftSide.x, leftSide.y, rightSide.x, rightSide.y);
            // ADD THIS INSTEAD
            lblpicture.repaint();
        }
        [...]
        public void actionPerformed(ActionEvent e) {
            [...]
            // REMOVE THIS LINE
            //BufferedImage img = null;
            [...]
            // REMOVE THIS LINE
            //lblpicture.setIcon(new ImageIcon(img));
            // ADD THIS LINE INSTEAD
            lblpicture.repaint();
            [...]
        }
    }
}