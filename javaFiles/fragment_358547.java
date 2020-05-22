public static void main(String[] args) {
    JFrame frame = new JFrame();

    Dimension min = new Dimension(500,500);
    frame.setMinimumSize(min);

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension max = toolkit.getScreenSize();
    frame.setMaximumSize(max);

    frame.setVisible(true);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

}