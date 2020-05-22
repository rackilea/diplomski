public static void main (String[] arg) {
    MainFrame mainFrame = new MainFrame();
    mainFrame.setVisible(true);
}

public static class MainFrame extends JFrame{
    public MainFrame() {
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        MainPanel mainPanel = new MainPanel();
        this.add(mainPanel);
    }
}

public static class MainPanel extends JPanel{
    public void paint(Graphics g) {
        super.paint(g);
        // Panel Size = 400 X 400
        g.drawLine(200, 0, 200, 400); // Y Axis
        g.drawLine(0, 200, 400, 200); // X Axis

        // Create Transform
        AffineTransform at = new AffineTransform();
        at.translate(200, 200); // Move Center Form (0, 0) To JPanel Center (200, 200)

        // Change Transform 
        at.translate(-200, 0); // Move Center

        // Set Transform To Graphics2D
        Graphics2D g2d = (Graphics2D) g;
        g2d.setTransform(at);

        // Draw Rectangle By Graphics2D
        g2d.fillRect(100, 100, 100, 100);
    }
}