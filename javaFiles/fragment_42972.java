public class Console {

public static void run (final JFrame f, final int width, final int height) {

    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            f.setTitle(f.getClass().getSimpleName());
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(width, height);
            f.setVisible(true);
            f.setLocationRelativeTo(null);
        }
    });

}