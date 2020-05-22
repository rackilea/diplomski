import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new MyStoreGui());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public final class MyStoreGui extends JPanel {

        public MyStoreGui() {
            setLayout(new GridBagLayout());
            //setLayout(new FlowLayout());
            // create custom panels
            StandardServices standard = new StandardServices();
            HourlyService hourly = new HourlyService();

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            //Create the button panel
            JPanel buttonPanel = buildButtonPanel();

            add(standard, gbc);
            add(hourly, gbc);
            add(buttonPanel, gbc);

            // Display the window
            setVisible(true);
        }

        protected JPanel buildButtonPanel() {
            JPanel panel = new JPanel();
            panel.add(new JButton("Calclate Changes"));
            panel.add(new JButton("Exit"));
            return panel;
        }
    }

    public class StandardServices extends JPanel {

        public StandardServices() {
            // Create GridLayout manager with 5 rows and 1 column
            setLayout(new GridLayout(5, 1));

            // Create the check boxes.
            JCheckBox iHardDrive = new JCheckBox("Install Hard Drive ($25.00)");
            JCheckBox ram = new JCheckBox("Install Ram ($15.00)");
            JCheckBox virus = new JCheckBox("Remove Virus ($50.00)");
            JCheckBox fHardDrive = new JCheckBox("Format Hard Drive ($80.00)");
            JCheckBox labourQuote = new JCheckBox("Hourly Labour Qoute ($10.00)");

            //Add a border around the panel.
            setBorder(BorderFactory.createTitledBorder("Standard Services"));

            // Add the checkboxes to the panel.
            add(iHardDrive);
            add(ram);
            add(virus);
            add(fHardDrive);
            add(labourQuote);
        }
    }

    public class HourlyService extends JPanel {

        public HourlyService() {
            // Created grid layout with 2 rows, 1 column
            setLayout(new GridLayout(2, 1));

            // Create labels to display instructions.
            JLabel cost = new JLabel("Parts Cost:");
            JLabel labour = new JLabel("Hours of Labour:");

            // Create two text fields 10 characters wide.
            JTextField costTextField = new JTextField(10);
            JTextField labourTextField = new JTextField(10);

            // Place a 0 in the text fields.
            costTextField.setText("0");
            labourTextField.setText("0");

            // Add a border around the layout
            setBorder(BorderFactory.createTitledBorder("Hourly Service"));

            // Add labels and text fields to the panel.
            add(cost);
            add(costTextField);
            add(labour);
            add(labourTextField);

        }
    }
}