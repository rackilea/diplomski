public class YouTubeViewer {

public static void main(String[] args) {
    NativeInterface.open();
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            JFrame frame = new JFrame("YouTube Viewer");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.getContentPane().add(getBrowserPanel(), BorderLayout.CENTER);
            frame.setSize(800, 600);
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        }
    });
    NativeInterface.runEventPump();
    // don't forget to properly close native components
    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        @Override
        public void run() {
            NativeInterface.close();
        }
    }));
}

public static JPanel getBrowserPanel() {
    JPanel webBrowserPanel = new JPanel(new BorderLayout());
    JWebBrowser webBrowser = new JWebBrowser();
    webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
    webBrowser.setBarsVisible(false);
    webBrowser.navigate("https://www.youtube.com/v/b-Cr0EWwaTk?fs=1");
    return webBrowserPanel;
}
}