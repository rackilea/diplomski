public class GUI extends JFrame {

    public static GUI gui;

    public static void main(String[] args) {

        gui = new GUI();
        gui.setVisible(true);
        gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }