import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class Foo3 {
    private static void createAndShowGui() {
        final MainPanel1 mainPanel1 = new MainPanel1();
        final ToolPanel1 toolPanel1 = new ToolPanel1();

        JFrame frame = new JFrame("Foo3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JDialog dialog = new JDialog(frame, "Toolbar", ModalityType.MODELESS);
        dialog.add(toolPanel1);
        dialog.pack();
        dialog.setLocationByPlatform(true);
        dialog.setVisible(true);

        toolPanel1.addPropertyChangeListener(ToolPanel1.ACTION_COMMAND, new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                mainPanel1.appendActionCommand((String) evt.getNewValue());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

class MainPanel1 extends JPanel {
    private JTextArea actionCommandArea = new JTextArea(30, 50);
    private JScrollPane scrollPane = new JScrollPane(actionCommandArea);

    public MainPanel1() {
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    public void appendActionCommand(String text) {
        actionCommandArea.append(text + "\n");
    }
}

class ToolPanel1 extends JPanel {
    public static final String ACTION_COMMAND = "action command";
    public static final String[] BTN_TEXTS  = {
        "Select Element",
        "Insert Image",
        "Insert Text",
        "Insert Hyperlink",
        "Change Page Background",
        "Insert Textbox",
        "Insert Radio Button", 
        "Insert Checkbox",
        "Insert Horizontal Rule",
        "Insert Button",
        "Insert Drop-Down List",
        "Insert List",
        "Add Script"
    };
    private String actionCommand = "";

    public ToolPanel1() {
        int rows = 0; // variable number of rows
        int cols = 2; // 2 columns
        int hgap = 5;
        int vgap = hgap;
        setLayout(new GridLayout(rows, cols, hgap, vgap));
        setBorder(BorderFactory.createEmptyBorder(hgap, hgap, hgap, hgap));

        for (String btnText : BTN_TEXTS) {
            add(new JButton(new ButtonAction(btnText)));
        }
    }

    public String getActionCommand() {
        return actionCommand;
    }

    private class ButtonAction extends AbstractAction {
        public ButtonAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String oldValue = "";
            String newValue = e.getActionCommand();
            actionCommand = newValue;
            ToolPanel1.this.firePropertyChange(ACTION_COMMAND, oldValue, newValue);
        }
    }
}