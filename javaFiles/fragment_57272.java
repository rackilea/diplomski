import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class RadioPanel extends JPanel implements ActionListener {
    private static final long serialVersionUID = -1890379016551779953L;
    private JCheckBox box;
    private JLabel label;

    public RadioPanel(String message) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        box = new JCheckBox();

        // here
        box.addActionListener(event -> {
            JCheckBox checkBox = (JCheckBox) event.getSource();
            if (checkBox.isSelected()) {
                System.out.println("Box clicked!");
            }
        });

        this.add(box, c);
        c.gridx = 1;
        c.gridy = 0;
        label = new JLabel(message);
        this.add(label, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}