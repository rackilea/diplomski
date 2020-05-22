public static void main(String[] args) throws Exception {

    final URL lenna =
        new URL("http://upload.wikimedia.org/wikipedia/en/2/24/Lenna.png");

    final ImageComponent image = new ImageComponent(lenna);

    JFrame frame = new JFrame("Test");
    frame.add(new JScrollPane(image));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}