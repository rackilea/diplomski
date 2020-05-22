package gui.examples;


import java.awt.event.*;
import javax.swing.*;

public class MaisamCustom {

    JFrame frame = new JFrame("My Desktop App");
    JPanel panel = new JPanel();
    protected JTextField txt1 = new JTextField(8),
            txt2 = new JTextField(8);
    JButton enter_btn = new JButton("Enter");
    public void launchFrame() {

        JLabel label1 = new JLabel("   "),
                label3 = new JLabel("   "),
                label4 = new JLabel("   "),
                label5 = new JLabel("   "),
                label2 = new JLabel("                  My Comparision Program");
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(label3);
        panel.add(label2);
        panel.add(label4);
        panel.add(txt1);
        panel.add(label1);
        panel.add(txt2);
        panel.add(label5);
        enter_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (MaisamCustom.this instanceof LogicClass){
                    LogicClass logicClassObj = (LogicClass)MaisamCustom.this;
                    logicClassObj.enterButton();
                }
            }
        });
        panel.add(enter_btn);
        frame.setResizable(false);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        MaisamCustom obj = new LogicClass();
        try {
            obj.launchFrame();
        } catch (Exception ex) {
            System.out.println("Some issue while launching the application...");
        }
    }


}