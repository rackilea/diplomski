import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class Jlist {
    JFrame frame;
    JList<String> list;
    JButton button;

    public Jlist(){
        init();
    }

    public void init(){
        frame = new JFrame("Sample");
        frame.setSize(300, 300);
        frame.setLayout(new  BorderLayout(30, 30));

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("A");
        model.addElement("B");
        model.addElement("C");
        model.addElement("D");
        model.addElement("E");

        list = new JList<>();

        list.setModel(model);
        JScrollPane pane = new JScrollPane(list);
        pane.setViewportView(list);

        button = new JButton("Get");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonActionPerformed();
            }
        });


        frame.add(pane, BorderLayout.NORTH);
        frame.add(button, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public void buttonActionPerformed(){
        for(int i = 0; i< list.getModel().getSize();i++){
            System.out.println(list.getModel().getElementAt(i));
        }
    }
    public static void main(String[] args) {
        new Jlist();
    }
}