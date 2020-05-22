public class TestPane extends JPanel {

    public TestPane() {
        setLayout(new GridBagLayout());
        BufferedImage img = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setBackground(new Color(255, 255, 255, 0));
        g2d.clearRect(0, 0, 32, 32);
        g2d.dispose();
        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < 3; row++) {
            gbc.gridy = row;
            for (int col = 0; col < 3; col++) {
                gbc.gridx = col;
                add(new JButton(new ImageIcon(img)), gbc);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

}