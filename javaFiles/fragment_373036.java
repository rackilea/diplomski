import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionListenerExample1 extends JFrame
        implements ActionListener, KeyListener {
    private static final long serialVersionUID = 1L;

    private JTextField searchText;
    private JButton searchButton1;
    private JButton searchButton2;

    public ActionListenerExample1() {
        initialize();

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    protected void initialize() {
        searchText = new JTextField(30);
        searchButton1 = new JButton("Search 1");
        searchButton2 = new JButton("Search 2");

        searchText.addKeyListener(this);
        searchButton1.addActionListener(this);
        searchButton2.addActionListener(new ButtonAction());

        this.setLayout(new FlowLayout());
        this.add(searchText);
        this.add(searchButton1);
        this.add(searchButton2);
    }

    public static void main(String[] args) {
        new ActionListenerExample1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton1) {
            buttonAction("GLOBAL LISTENER");
        }
    }

    private class ButtonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonAction("LOCAL LISTENER");
        }
    }

    private void buttonAction(String label) {
        JOptionPane.showMessageDialog(this,
            String.format("%s: %s", label, searchText.getText()));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_A) {
            buttonAction("KEYBOARD");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }
}