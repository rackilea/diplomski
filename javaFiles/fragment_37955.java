public class MainFrame extends JFrame {

public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setAlwaysOnTop(false);
                    frame.setMinimumSize(new Dimension(545, 693));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public mainFrame() {


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 545, 693);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

//Continue adding components here...
}