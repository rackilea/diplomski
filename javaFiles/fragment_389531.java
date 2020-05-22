import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class JToggleButtonAction {

    public static void main(String args[]) {
        JFrame frame = new JFrame("Selecting Toggle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JToggleButton toggleButton = new JToggleButton("Toggle Button");
        final JToggleButton toggleButton1 = new JToggleButton("Another Toggle Button");
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
                boolean selected = abstractButton.getModel().isSelected();
                System.out.println("Action - selected=" + selected + "\n");
                toggleButton1.setSelected(selected);
            }
        };
        toggleButton.addActionListener(actionListener);
        frame.add(toggleButton, BorderLayout.NORTH);
        frame.add(toggleButton1, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}