import javax.swing.*;

public class Jpl extends JPanel {
    public static final String[] LABEL_TEXT = {"Monday", "Tuesday", 
        "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public Jpl() {
        for (int i = 0; i < LABEL_TEXT.length; i++) {
            JLabel lbl = new JLabel();
            lbl.setText(LABEL_TEXT[i]);
            add(lbl);
        }
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("Jpl");
        frame.getContentPane().add(new Jpl());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}