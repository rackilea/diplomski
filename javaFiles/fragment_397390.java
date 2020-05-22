import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Wizard {
    public Wizard() {
        JFrame wizardFrame = new JFrame();
        wizardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wizardFrame.setLayout(new GridLayout(2, 5));
        String name;
        for (int i = 1; i < 11; i++) {
            name = "Maschine " + i;
            MashinePanel mashinePanel = new MashinePanel(name, i);
            wizardFrame.add(mashinePanel.getPanel());
        }
        wizardFrame.pack();
        wizardFrame.setVisible(true);
    }

    public static class MashinePanel implements ActionListener {
        private final String name;
        private final int id;
        private JTextField maschineNameTF;
        private JFormattedTextField maschinePrioritaetTF;
        private JButton higher;
        private JPanel machinePanel;

        public MashinePanel(String name, int i) {
            super();
            this.name = name;
            this.id = i;
            machinePanel = new JPanel();
            machinePanel.setLayout(new BorderLayout());
            maschineNameTF = new JTextField(name, 10);
            machinePanel.add(maschineNameTF, BorderLayout.WEST);
            maschinePrioritaetTF = new JFormattedTextField(20);
            maschinePrioritaetTF.setColumns(10);
            machinePanel.add(maschinePrioritaetTF, BorderLayout.CENTER);
            higher = new JButton("Higher " + i);
            higher.addActionListener(this);
            machinePanel.add(higher, BorderLayout.NORTH);
        }

        public JPanel getPanel() {
            return machinePanel;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getActionCommand().contains("Higher")) {
                Object value = maschinePrioritaetTF.getValue();
                int priority = 20;
                if (value instanceof Integer) {
                    priority = (Integer) value;
                }
                maschinePrioritaetTF.setValue(priority + 1);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Wizard();
            }
        });
    }
}