public class ImageApplet extends JApplet {

    private JPanel paneSouth = new JPanel();
    private JTextArea bio = new JTextArea("bio thing");
    private JButton play = new JButton("Play");
    private Image myPicture;
    private ImageIcon icon;
    private JLabel label;

    public void init() {
        try {
            URL pic = new URL(getDocumentBase(), "sample.jpg");
            myPicture = ImageIO.read(pic);
            icon = new ImageIcon(myPicture);
            label = new JLabel(icon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // add image
        add(label, BorderLayout.NORTH);
        // bio
        add(bio, BorderLayout.CENTER);
        // sound
        paneSouth.add(play);
        add(paneSouth, BorderLayout.SOUTH);

        // here add your sound declaration and button event...
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}