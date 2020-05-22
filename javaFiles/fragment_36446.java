public class Main {

    private static void createAndShowGUI() {
        Jf53136132 f = new Jf53136132();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(640, 480));
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }



    void execute() {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createAndShowGUI();
            }
        });
    }



    public static void main(String[] args) {
        new Main().execute();
    }

}