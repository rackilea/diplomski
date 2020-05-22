public class ApplicationGame extends JFrame {
    ApplicationGame() {
        JPanel graphicsPanel = new JPanel(new BorderLayout()) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString("Working...", 50, 50);
                System.out.println("Painted onto the panel");
            }
        };
        graphicsPanel.setPreferredSize(new Dimension(200, 200));
        add(graphicsPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ApplicationGame::new);
    }
}