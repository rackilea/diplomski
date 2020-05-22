class PageScreen1 extends JPanel {
    private PageScreen1() {
        setLayout( new BorderLayout() );

        ImageIcon image = new ImageIcon("images/Front1.png");
        JLabel label2 = new JLabel(image, JLabel.CENTER);
        label2.setBounds( 10, 55, 1600, 900 );
        add(label2);
    }
}