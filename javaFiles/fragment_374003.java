public class PanelForm extends javax.swing.JPanel {
    private BufferedImage image;

    public PanelForm() {
        try {
            image = ImageIO.read(getClass().getResource("/path/to/image/png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }  
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new PanelForm());     //  <--- add it here
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}