import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Puzzle {
    private static List<JButton> btns = new ArrayList<JButton>();

    static class MyButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();

            int emptyIndex = -1;
            int currentInex = -1;
            for (int i = 0; i < btns.size(); i++) {
                if (btns.get(i).getText().equals("")) {
                    emptyIndex = i;
                } else if (btns.get(i).getText().equals(btn.getText())) {
                    currentInex = i;
                }
            }

            int left = currentInex - 1;
            int right = currentInex + 1;
            int top = currentInex - 4;
            int bottom = currentInex + 4;

            if (emptyIndex == left || emptyIndex == right || emptyIndex == top
                    || emptyIndex == bottom) {
                JButton emptyBtn = btns.get(emptyIndex);
                emptyBtn.setText(btn.getText());
                btn.setText("");
            }
        }
    }

    public static void main(String[] a) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < 15; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(new MyButtonActionListener());
            btns.add(btn);
        }
        JButton empty = new JButton("");
        empty.addActionListener(new MyButtonActionListener());
        btns.add(empty);

        Collections.shuffle(btns);
        for (JButton btn : btns) {
            panel.add(btn);
        }

        frame.setTitle("The 15 game");
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}