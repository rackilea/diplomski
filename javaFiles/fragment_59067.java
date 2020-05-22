import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame() {

        setLayout(new BorderLayout());
        getContentPane().setPreferredSize(new Dimension(400, 250));

        JButton btn = new JButton("Click Me");
        btn.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                setVisible(false);

                JFrame frame2 = new JFrame();
                frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame2.setLocation(300, 150);
                frame2.add(new JLabel("This is frame2."));
                frame2.setVisible(true);
                frame2.setSize(200, 200);

            } 
        } );
        add(btn,BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame frame = new MyFrame();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocation(150, 150);
                frame.add(new JLabel("This is frame1."), BorderLayout.NORTH);
                frame.setVisible(true);
            }
        });
    }
}