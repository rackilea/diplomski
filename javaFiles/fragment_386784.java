import javax.swing.*;

@SuppressWarnings("serial")
public class Synthetic_Division extends JFrame {
    void init() {
        JTextField JTF = new JTextField();
        JLabel label = new JLabel();
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(JTF);
        this.add(panel);
    }

    public Synthetic_Division() {
        super("Synthetic Division");
        this.init();
        this.setSize(600, 400);
        this.setVisible(true);
    }

    //Here is the part you were missing. Everything else is fine.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new Synthetic_Division();
            }
        });
    }
}