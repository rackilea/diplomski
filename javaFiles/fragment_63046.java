import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Checklist extends JFrame {

    private JLabel      description;
    private JButton     send;
    private JTextField  text[]=new JTextField[10];
    private JCheckBox   cb[]=new JCheckBox[10];

    public Checklist() {
    setTitle("Activities");
    setSize(400,400);
    setupWidgets();
    setVisible(true);       
}

private void setupWidgets() {
    JPanel  pn_center   = new JPanel(new GridLayout(10,1));
    JPanel  pn_west     = new JPanel(new GridLayout(10,1));

    description     = new JLabel("List your activities and uncheck the irrelevant ones");
    send            = new JButton("Send Checklist");

    for (int i=0; i<10; i++) {
        text[i]  = new JTextField();
        cb[i]    = new JCheckBox();
    }

    add(description, BorderLayout.NORTH);
    add(pn_center, BorderLayout.CENTER);
    add(pn_west, BorderLayout.WEST);
    add(send, BorderLayout.SOUTH);

    for (int i=0; i<10; i++){

        pn_center.add(text[i]);
        pn_west.add(cb[i]);
    }
}

public static void main(String[] args) {
    new Checklist();
}
}