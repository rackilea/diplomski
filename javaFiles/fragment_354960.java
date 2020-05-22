public class MoveRectangleArrowKeys {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MoveRectangleArrowKeys::new);
    }

    MoveRectangleArrowKeys() {
        JFrame frame = new JFrame("Move Rectangle with Arrow Keys");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Gameseeting());
        frame.setVisible(true);
    }
}