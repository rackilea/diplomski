public class Main extends JApplet {

    public void paint(Graphics g) {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        add(panel);

        JLabel label1 = new JLabel();
        panel.add(label1);
        JLabel label2 = new JLabel();
        panel.add(label2);
        JLabel label3 = new JLabel();
        panel.add(label3);
        JLabel label4 = new JLabel();
        panel.add(label4);

        try {
            URL url = new URL("YOU_IMAGE_URL.jpg");
            Image myPicture = getImage(url);

            label1.setIcon(new ImageIcon(myPicture));
            label2.setIcon(new ImageIcon(myPicture));
            label3.setIcon(new ImageIcon(myPicture));
            label4.setIcon(new ImageIcon(myPicture));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}