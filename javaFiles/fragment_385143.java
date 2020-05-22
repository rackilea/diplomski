import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTextArea ta;

        public TestPane() {
            setLayout(new BorderLayout());
            ta = new JTextArea(5, 20);
            add(new JScrollPane(ta));

            JButton btn = new JButton("Add and to top");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ta.setText("jhggjhg\nhugffsrdtfg\ngfdrtdf\nhgftrsdf\nytfresrdcfvg\nuytyrdtesrdfgg\ntdrfygvhct\njh"
                            + "gfda\njftyuyiugcf\nhfuygihvftyughbuy\nhgyuftydfhgfyc\ndstryrfdts");
                    ta.setCaretPosition(0);
                }
            });

            add(btn, BorderLayout.SOUTH);
        }


    }

}