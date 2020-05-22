public class MainWindow extends JFrame {

    private MainPanel mp = new MainPanel();

    public static void main(String[] args) {

        new MainWindow();
    }

    public MainWindow() {

        setContentPane(mp);
        setTitle("Calculateur sur 100");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}