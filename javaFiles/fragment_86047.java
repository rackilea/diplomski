import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class PopupPanelDemo {
    public static void main(String ags[]) {
        JFrame f = new JFrame();
        JLabel l = new JLabel("Date");
        JTextField t = new JTextField(10);
        JPanel p = new JPanel();
        JButton b = new JButton("Show");

        p.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        p.setBackground(Color.red);
        p.add(new JLabel("Test"));

        f.setLayout(new FlowLayout());
        f.add(l);
        f.add(t);
        f.add(b);

        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                PopupFactory pf = PopupFactory.getSharedInstance();
                p.setSize(t.getWidth(), t.getHeight());
                p.setPreferredSize(new Dimension(t.getWidth(), t.getHeight()));
                Point l = t.getLocationOnScreen();
                Popup popup = pf.getPopup(f, p, l.x, l.y + t.getHeight());
                popup.show();
            }
        });
    }
}