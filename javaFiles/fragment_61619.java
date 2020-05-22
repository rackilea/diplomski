import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class MainClass {
  public static void main(String[] args) {
    JRadioButton dem = new JRadioButton("Bill", false);
    dem.setActionCommand("Bill");
    JRadioButton rep = new JRadioButton("Bob", false);
    rep.setActionCommand("Bob");
    JRadioButton ind = new JRadioButton("Ross", false);
    ind.setActionCommand("Ross");

    final ButtonGroup group = new ButtonGroup();
    group.add(dem);
    group.add(rep);
    group.add(ind);

    class VoteActionListener implements ActionListener {
      public void actionPerformed(ActionEvent ex) {
        String choice = group.getSelection().getActionCommand();
        System.out.println("ACTION Candidate Selected: " + choice);
      }
    }

    class VoteItemListener implements ItemListener {
      public void itemStateChanged(ItemEvent ex) {
        String item = ((AbstractButton) ex.getItemSelectable()).getActionCommand();
        boolean selected = (ex.getStateChange() == ItemEvent.SELECTED);
        System.out.println("ITEM Candidate Selected: " + selected + " Selection: " + item);
      }
    }

    ActionListener al = new VoteActionListener();
    dem.addActionListener(al);
    rep.addActionListener(al);
    ind.addActionListener(al);

    ItemListener il = new VoteItemListener();
    dem.addItemListener(il);
    rep.addItemListener(il);
    ind.addItemListener(il);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = frame.getContentPane();
    c.setLayout(new GridLayout(4, 1));
    c.add(new JLabel("Please Cast Your Vote"));
    c.add(dem);
    c.add(rep);
    c.add(ind);
    frame.pack();
    frame.setVisible(true);
  }
}