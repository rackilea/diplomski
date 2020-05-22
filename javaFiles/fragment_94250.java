import java.awt.BorderLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TestFrame extends JFrame{

    public TestFrame(){
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void init() {
        JTextField f1 = new JTextField(5);
        f1.addFocusListener(getFocusListener());
        add(f1,BorderLayout.SOUTH);
        add(new JTextField(5),BorderLayout.NORTH);
    }


    private FocusListener getFocusListener() {
        return new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                System.out.println("action");
            }
        };
    }

    public static void main(String... s){
        new TestFrame();
    }

}