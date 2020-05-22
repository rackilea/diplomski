public class Efi extends JFrame {

    public JButton button;

    public Efi() {
        super("EFI'S APPLICATION"); //or you can omit this and use setTitle();
        setLayout(new BorderLayout());
        setSize(250,300);


        button = new JButton("IMAGE");
        add(button, BorderLayout.SOUTH);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImagePanel imagePanel = new ImagePanel();

                //JFrames methods
                add(imagePanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });

        //Added those
        setLocationRelativeTo(null); //This is for centering the frame to your screen.
        setDefaultCloseOperation(EXIT_ON_CLOSE); //This for closing your application after you closing the window.

    }

    public class ImagePanel extends JPanel {

        private BufferedImage image;

        public ImagePanel() {
            try {
                image = ImageIO.read(new File("img.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            setBorder(BorderFactory.createLineBorder(Color.black, 2));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }
    }

    public static void main(String args[]) {
        new Efi().setVisible(true);
    }
}