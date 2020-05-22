import java.awt.*;
import javax.swing.*;

public class Gui extends JFrame {
    private JRadioButton okOnly = new JRadioButton("Ok ");
    private JRadioButton okCancel = new JRadioButton("Ok Cancel");
    private JRadioButton yesNoCancel = new JRadioButton("Yes No Cancel");
    private JRadioButton yesNo = new JRadioButton("Yes No");

    private void initGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        // JPanel panel = new JPanel();
        // panel.setPreferredSize(new Dimension(450, 450));

        setPreferredSize(new Dimension(450, 450));

        Box buttonBox = Box.createVerticalBox();
        ButtonGroup buttons = new ButtonGroup();

        buttons.add(okOnly);
        buttons.add(okCancel);
        buttons.add(yesNoCancel);
        buttons.add(yesNo);

        buttonBox.add(okOnly);
        buttonBox.add(okCancel);
        buttonBox.add(yesNoCancel);
        buttonBox.add(yesNo);
        buttonBox.setBorder(BorderFactory.createTitledBorder("Buttons"));

        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridConstraints.weightx = 1;
        gridConstraints.weighty = 1;

        // panel.add(buttonBox, gridConstraints);
        add(buttonBox, gridConstraints);
        // getContentPane().add(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private static void createAndShowGui() {
        new Gui().initGUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}