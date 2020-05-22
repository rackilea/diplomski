package layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CardLayoutExample extends JFrame{
    JPanel totelPanel,btnPan,showPan;
    JButton btn1,btn2;

    public static void main(String[] args) {
        CardLayoutExample ex = new CardLayoutExample();
        ex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ex.pack();
        ex.setLocationRelativeTo(null);
        ex.setTitle("BookClube library system");
        ex.setVisible(true);
    }

    public CardLayoutExample(){
        btn1 = new JButton("menu button");
        btn2 = new JButton("back button");
        CardLayout c1 = new CardLayout();

        btnPan = new JPanel();
        btnPan.add(btn1);

        showPan = new JPanel();
        showPan.add(btn2);

        totelPanel = new JPanel(c1);
        totelPanel.add(btn1,"1");
        totelPanel.add(btn2,"2");
        c1.show(totelPanel,"1");

        JPanel fullLayout = new JPanel(new BorderLayout());
        fullLayout.add(totelPanel,BorderLayout.NORTH);

        add(fullLayout);
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                c1.show(totelPanel,"2");
            }
        });

        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                c1.show(totelPanel,"1");
            }
        });


    }

}