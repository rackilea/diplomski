import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Test {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class TestPane extends JPanel {

        private List<String> rList = new ArrayList<>(7);
        private List<JButton> summary = new ArrayList<>(7);

        public TestPane() {
            setLayout(new GridLayout(0, 7));

            List<String> values = new ArrayList<String>(7 * 7);
            for (int index = 0; index < 7 * 7; index++) {
                values.add(Integer.toString(index + 1));
            }

            Collections.shuffle(values);
            rList.addAll(values.subList(0, 7));
            Collections.shuffle(values);

            System.out.println(rList);

            for (String value : values) {
                JButton btn = makeButton(value);
                btn.addActionListener(new ActionHandler(btn));
                add(btn);
            }

            String text = "SUMMARY";
            for (String value : text.split("")) {
                add(makeButton(value));
            }
            for (int index = 0; index < 7; index++) {
                JButton btn = makeButton("");
                summary.add(btn);
                add(btn);
            }
        }

        public JButton makeButton(String text) {
            JButton btn = new JButton(text);
            btn.setFocusPainted(false);
            btn.setOpaque(true);
            btn.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY), new EmptyBorder(4, 8, 4, 8)));
            return btn;
        }

        public class ActionHandler implements ActionListener {

            private JButton button;

            public ActionHandler(JButton button) {
                this.button = button;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String first = rList.get(0);
                String cmd = e.getActionCommand();
                JButton btn = (JButton) e.getSource();
                System.out.println("cmd = " + cmd);
                System.out.println("first = " + first);
                if (cmd.equals(first)) {
                    btn.setBackground(Color.GREEN);
                    for (int index = 0; index < rList.size(); index++) {
                        JButton b = summary.get(index);
                        String text = rList.get(index);
                        b.setText(text);
                        if (index == 0) {
                            b.setBackground(Color.GREEN);
                        } else {
                            b.setBackground(Color.YELLOW);
                        }
                    }
                } else if (rList.contains(cmd)) {
                    btn.setBackground(Color.YELLOW);
                }
            }

        }

    }
}