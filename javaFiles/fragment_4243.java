import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FormSample {
    private JFrame frame;
    private JPanel topRightPane;
    private JPanel centerPane;
    private JPanel centerWithButtonPane;
    private JPanel buttonsPane;

    private JTextField monthField;
    private JTextField yearField;

    private JTextField serviceField;
    private JTextField amountField;
    private JTextField counterField;
    private JTextField divisionField;

    private static final int LEFT_MARGIN = 50; //Increase / Decrease to add extra space between components
    private static final int RIGHT_MARGIN = LEFT_MARGIN;

    //Change insets accordingly to add extra space between components (top, left, bottom, right)
    private static final Insets leftInsets = new Insets(0, LEFT_MARGIN, 0, 0);
    private static final Insets rightInsets = new Insets(0, 0, 0, RIGHT_MARGIN);
    private static final Insets defaultInsets = new Insets(0, 0, 0, 0);

    private JButton saveCurrentButton;
    private JButton saveAllButton;
    private JButton resetButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new FormSample()::createAndShowGui);
    }

    private void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());

        monthField = new JTextField(10);
        yearField = new JTextField(10);

        serviceField = new JTextField(10);
        amountField = new JTextField(10);
        counterField = new JTextField(10);
        divisionField = new JTextField(10);

        saveCurrentButton = new JButton("Save Current");
        saveAllButton = new JButton("Save all");
        resetButton = new JButton("Reset");

        buttonsPane = new JPanel();

        topRightPane = new JPanel();
        topRightPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

        topRightPane.add(new JLabel("Month"));
        topRightPane.add(monthField);
        topRightPane.add(new JLabel("Year"));
        topRightPane.add(yearField);

        centerWithButtonPane = new JPanel();
        centerWithButtonPane.setLayout(new BoxLayout(centerWithButtonPane, BoxLayout.PAGE_AXIS));

        Box box = Box.createHorizontalBox();
        box.add(new JLabel("Statement"));
        box.add(Box.createHorizontalGlue());
        box.add(topRightPane);

        centerPane = new JPanel();
        centerPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = defaultInsets;
        centerPane.add(new JLabel("Service"), gbc);

        gbc.gridx = 1;
        gbc.insets = rightInsets;
        centerPane.add(serviceField, gbc);

        gbc.gridx = 2;
        gbc.insets = leftInsets;
        centerPane.add(new JLabel("Counter"), gbc);

        gbc.gridx = 3;
        gbc.insets = defaultInsets;
        centerPane.add(counterField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = defaultInsets;
        centerPane.add(new JLabel("Amount"), gbc);

        gbc.gridx = 1;
        gbc.insets = rightInsets;
        centerPane.add(amountField, gbc);

        gbc.gridx = 2;
        gbc.insets = leftInsets;
        centerPane.add(new JLabel("Division"), gbc);

        gbc.gridx = 3;
        gbc.insets = defaultInsets;
        centerPane.add(divisionField, gbc);

        saveCurrentButton.setAlignmentX(Component.CENTER_ALIGNMENT); //Force centered alignment for our JButton
        centerWithButtonPane.add(centerPane);
        centerWithButtonPane.add(saveCurrentButton);

        buttonsPane.add(saveAllButton);
        buttonsPane.add(resetButton);

        frame.add(box, BorderLayout.NORTH);
        frame.add(centerWithButtonPane, BorderLayout.CENTER);
        frame.add(buttonsPane, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}