import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTestinf extends JPanel {

    JRadioButton one = new JRadioButton();
    JRadioButton two = new JRadioButton();
    int i = 0;

    public static void main(String[] args) {
        JFrame window = new JFrame("RadioButtonDemo");
        // JComponent ContentPane = new JTestinf();
        JTestinf jTestinf = new JTestinf();

        window.setContentPane(jTestinf);
        window.pack();
        window.setVisible(true);
        TimerListener timerListener = new TimerListener(jTestinf);
        Timer time = new Timer(500, timerListener);
        time.start();
    }

    public JTestinf() {
        one.setText("" + i++);
        two.setText("" + i++);
        ButtonGroup group = new ButtonGroup();
        group.add(one);
        group.add(two);

        one.addActionListener(new RadioListener());
        two.addActionListener(new RadioListener());

        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(one);
        radioPanel.add(two);
        one.setActionCommand("one");
        two.setActionCommand("two");

        add(radioPanel, BorderLayout.LINE_START);
    }

    private class RadioListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO put in code for radio button            
            System.out.println("JRadioButton Pressed: " + e.getActionCommand());
        }
    }

    public void setRadioText(int index) {
        one.setText("" + index);
        two.setText("" + (index + 1));
    }
}

class TimerListener implements ActionListener {
    private int index = 0;

    private JTestinf jTestinf;

    public TimerListener(JTestinf jTestinf) {
        this.jTestinf = jTestinf;
    }

    public void actionPerformed(ActionEvent e) {
        index++;
        jTestinf.setRadioText(index);
    }
}