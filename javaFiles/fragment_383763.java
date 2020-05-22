public class MainUI extends javax.swing.JFrame {
    public static void main(String[] args) {
        final Player player = new Player();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainUI(player).setVisible(true);
            }
        });
        player.changeState(); // You can do this
        // player = new Player(); // You can't do that
    }
}