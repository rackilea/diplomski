import java.awt.*;
import javax.swing.*;

public class WelcomeExample
{
    private JPanel headerPanel;
    private JButton logoutButton;

    private JPanel leavePanel;
    private JRadioButton casualRButton;
    private JRadioButton specialRButton;
    private JRadioButton sickRButton;
    private JRadioButton privilegeRButton;
    private ButtonGroup radioButtonGroup;

    private JTextField leaveDaysField;
    private JButton checkLeaveButton;

    private JTextArea notesArea;
    private JScrollPane notesScroller;

    private JButton applyLeaveButton;

    private String headerText = "<html><body><h1><font " + 
            "color=\"red\">Welcome : </font><font color" +
            "=\"blue\">Code Zero</font></h1></body></html>";

    private void displayGUI()
    {
        JFrame frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5, 5));
        contentPane.setBorder(
            BorderFactory.createEmptyBorder(5, 5, 5, 5));

        headerPanel = getHeaderPanel();
        leavePanel = getLeavePanel();

        contentPane.add(headerPanel, BorderLayout.PAGE_START);
        contentPane.add(leavePanel, BorderLayout.CENTER);
        contentPane.add(getApplyPanel(), BorderLayout.PAGE_END);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JPanel getHeaderPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JLabel headerLabel = new JLabel(headerText, JLabel.CENTER);
        JPanel buttonPanel = new JPanel();
        logoutButton = new JButton("Logout");
        buttonPanel.add(logoutButton);
        panel.add(headerLabel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.LINE_END);
        panel.add(new JSeparator(
            SwingConstants.HORIZONTAL), BorderLayout.PAGE_END);

        return panel;
    }

    private JPanel getLeavePanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel leaveHeaderPanel = new JPanel();
        leaveHeaderPanel.setLayout(new GridLayout(0, 1, 5, 5));
        leaveHeaderPanel.setBorder(
            BorderFactory.createTitledBorder("Choose a leave type : "));
        JPanel leaveTypePanel = new JPanel();
        leaveTypePanel.setLayout(new FlowLayout(
                                FlowLayout.LEFT, 5, 5));
        casualRButton = new JRadioButton("Casual Leave");
        specialRButton = new JRadioButton("Special Leave");
        sickRButton = new JRadioButton("Sick Leave");
        privilegeRButton = new JRadioButton("Privilege Leave");

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(casualRButton);
        radioButtonGroup.add(specialRButton);
        radioButtonGroup.add(sickRButton);
        radioButtonGroup.add(privilegeRButton);

        leaveTypePanel.add(casualRButton);
        leaveTypePanel.add(specialRButton);
        leaveTypePanel.add(sickRButton);
        leaveTypePanel.add(privilegeRButton);

        JPanel applyLeavePanel = new JPanel();
        applyLeavePanel.setLayout(new FlowLayout(
                                FlowLayout.LEFT, 5, 5));
        JLabel applyLeaveLabel = new JLabel(
                "Apply for (No. of days) : ", JLabel.CENTER);
        leaveDaysField = new JTextField(5);
        checkLeaveButton = new JButton("Check Leave Availability");

        applyLeavePanel.add(applyLeaveLabel);
        applyLeavePanel.add(leaveDaysField);
        applyLeavePanel.add(checkLeaveButton);

        leaveHeaderPanel.add(leaveTypePanel);
        leaveHeaderPanel.add(applyLeavePanel);

        notesArea = new JTextArea(10, 10);
        notesScroller = new JScrollPane();
        notesScroller.setBorder(
            BorderFactory.createTitledBorder(
                "Leave Note (Max. 200 Characters) : "));
        notesScroller.setViewportView(notesArea);

        panel.add(leaveHeaderPanel, BorderLayout.PAGE_START);
        panel.add(notesScroller, BorderLayout.CENTER);

        return panel;
    }

    private JPanel getApplyPanel()
    {
        JPanel panel = new JPanel();
        applyLeaveButton = new JButton("Apply");
        panel.add(applyLeaveButton);

        return panel;
    }

    public static void main(String[] args)
    {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                new WelcomeExample().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}