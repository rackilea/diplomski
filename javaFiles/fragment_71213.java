import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Test extends JFrame {

    public Object       lock    = new Object();
    private JTextArea   area    = new JTextArea();

    public Test() {
        super("test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton send = new JButton("send");
        send.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (lock) {
                    lock.notify();
                }

            }
        });
        add(area);
        add(send, BorderLayout.SOUTH);
    }

    public String pullText() {
        String result = area.getText();
        area.setText("");
        return result;

    }

    public static void main(String[] args) {
        Test t = new Test();
        t.setSize(200, 200);
        t.setVisible(true);

        while (true) {
            synchronized (t.lock) {
                try {
                    t.lock.wait();
                    System.out.println(t.pullText());
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}