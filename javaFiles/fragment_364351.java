public class ScreenSaver {
    private static final JFrame frame = new JFrame();

    public static void startScreenSaver() throws Exception {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         frame.setBackground(Color.BLACK);
         frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         frame.setResizable(false);
         frame.setUndecorated(true);
         frame.validate();
         GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(frame);
         frame.setVisible(true);
    }

    public static void stopScreenSaver() {
         frame.setVisible(false);
    }
}