public static void main(String[] args) {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    JFrame frame = new JFrame("Jedia");
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setSize(screenSize);
    frame.setVisible(true);    // FIRST visible = true
    frame.setResizable(false); // THEN  resizable = false
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}