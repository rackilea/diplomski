public static void Options() {

    //Displays the title 
    JFrame window = new JFrame(setTitle);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setIconImage(favIcon);

    //window.getContentPane().setBackground(Color.black);
    BufferedImage img = null;
    try {
        img = ImageIO.read(new File("Background.png"));
        window.setContentPane(new JLabel(new ImageIcon(img)));
    } catch (IOException e) {
        e.printStackTrace();
    }
    window.setResizable(false);
    window.pack();
    window.setLocationRelativeTo(null);
    window.setVisible(true);
    window.toFront();
}