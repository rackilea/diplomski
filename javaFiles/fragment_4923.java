import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JCheckBoxtoLabel{
JCheckBox check;
String name;
JLabel txtVote;
ArrayList<JLabel> boxLabels;

public JCheckBoxtoLabel() {
    boxLabels = new ArrayList<JLabel>();

    JFrame frame = new JFrame();
    JPanel panel = createPanel();
    JPanel panel2 = panel2();

    frame.setLayout(new GridLayout(1,2));
    frame.add(panel); frame.add(panel2);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 300);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

private JPanel createPanel() {
    JPanel panel=new JPanel(new GridLayout(10,1));
    for(int i=0; i<10; i++){
        check=new JCheckBox();
        check.addActionListener(listener);
        check.setName("Select"+i);

        panel.add(check); 
    }

    return panel;
}

private JPanel panel2(){
    JPanel panel2=new JPanel(new GridLayout(5,1));
    for(int i=0; i<5; i++){
        txtVote=new JLabel();
        txtVote.setBorder(BorderFactory.createLineBorder(Color.RED));
        panel2.add(txtVote);
        boxLabels.add(txtVote);
    }
    return panel2;
}

ActionListener listener = new ActionListener() {
    @Override   
    public void actionPerformed(ActionEvent e) {
        check = (JCheckBox) e.getSource();
        if(!check.isSelected()){
            for(JLabel label: boxLabels){
                if(label.getText().equals(check.getName())) label.setText("");
            }
        }else{
            for(JLabel label: boxLabels){
                if(label.getText().isEmpty()){
                    label.setText(check.getName());
                    return;
                }
            }
        }
    }
};

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new JCheckBoxtoLabel();
        }
    });
}
}