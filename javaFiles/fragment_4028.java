import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JPanel {

    private String message;
    private int x;
    private int y;

    private MouseAdapter mouseAction = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent me) {
            message = input();
            x = me.getX();
            y = me.getY();
            repaint();
        }
    };

    public Main() {
        message = "Nothing to display yet...";
        x = y = 0;
    }

    private void displayGUI() {
        JFrame frame = new JFrame("Painting Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel(new BorderLayout(5, 5));

        addMouseListener(mouseAction);
        contentPane.add(this, BorderLayout.CENTER);

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
        g.drawString(message, x, y);
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