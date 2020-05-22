import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JPanel {

    private JButton button; 
    private String message;

    private ActionListener buttonAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            message = input();
            repaint();
        }
    };

    public Main() {
        message = "Nothing to display yet...";
    }

    private void displayGUI() {
        JFrame frame = new JFrame("Painting Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel(new BorderLayout(5, 5));
        button = new JButton("Get Message");
        button.addActionListener(buttonAction);

        contentPane.add(this, BorderLayout.CENTER);
        contentPane.add(button, BorderLayout.PAGE_END);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return (new Dimension(200, 200));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(message, 50, 50);
    }

    public String input() {
        String x = ((String)JOptionPane.showInputDialog (
                null, "Enter a string", "Test Project",
                            JOptionPane.QUESTION_MESSAGE,
                                        null, null, null));
        return x;
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new Main().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}