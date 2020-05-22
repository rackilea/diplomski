public static class PictureView extends JFrame {

    public PictureView(ImageIcon image) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel labelImage = new JLabel(image);
        panel.add(labelImage);
        setContentPane(panel);
    }

}