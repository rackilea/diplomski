import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class ActionForm {

    private static final long serialVersionUID = 1L;
    private JFrame frame;
    private JPanel namePanel;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private FlowLayout toolBarLayout = new FlowLayout();

    public ActionForm() {
        TitledBorder nameBorder = BorderFactory.createTitledBorder(
            "Change Description");
        nameBorder.setTitleJustification(TitledBorder.LEFT);
        namePanel = new JPanel(toolBarLayout);
        namePanel.setPreferredSize(new Dimension(150, 150));// hardCoded sizing
        namePanel.setMaximumSize(new Dimension(250, 150));  // hardCoded sizing
        namePanel.setMinimumSize(new Dimension(150, 150));  // hardCoded sizing
        nameLabel = new JLabel("ButtonName");
        nameTextField = new JTextField("Action's Name", 10);
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        namePanel.setBorder(nameBorder);
        namePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame = new JFrame("Mix / Max / PreferredSize for BoxLayout");
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),
            BoxLayout.Y_AXIS)); // otherwise nice exceptions java.awt.AWTError:
                                // BoxLayout can't be shared
        frame.add(namePanel);
        frame.setPreferredSize(new Dimension(970, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ActionForm form = new ActionForm();
            }
        });
    }
}