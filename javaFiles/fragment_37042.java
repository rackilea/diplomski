import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JRadioButtonChangeListener {
  public static void main(String args[]) {
    JFrame frame = new JFrame("Grouping Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(0, 1));

    ButtonGroup group = new ButtonGroup();
    JRadioButton aRadioButton = new JRadioButton("A");
    JRadioButton bRadioButton = new JRadioButton("B");

    ChangeListener changeListener = new ChangeListener() {
      public void stateChanged(ChangeEvent changEvent) {
        AbstractButton aButton = (AbstractButton)changEvent.getSource();
        ButtonModel aModel = aButton.getModel();
        boolean armed = aModel.isArmed();
        boolean pressed = aModel.isPressed();
        boolean selected = aModel.isSelected();
        System.out.println("Changed: " + armed + "/" + pressed + "/" +
          selected);
      }
    };

    panel.add(aRadioButton);
    group.add(aRadioButton);
    panel.add(bRadioButton);
    group.add(bRadioButton);

    aRadioButton.addChangeListener(changeListener);
    bRadioButton.addChangeListener(changeListener);

    frame.add(panel);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
  
}