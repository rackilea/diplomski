import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test2 extends JFrame {
    public Test2() {
        begin();
    }
    public void begin() {
        // creates the GUI Objects for the northPanel
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 4));

        JTextField searchBox = new JTextField();
        JLabel searchBoxLabel = new JLabel("Search ID #:");
        JButton search = new JButton("Search");

        northPanel.add(searchBoxLabel);
        northPanel.add(searchBox);
        northPanel.add(search);

        // creates the GUI OBjects for the southPanel
        JPanel southDivider = new JPanel();
        southDivider.setLayout(new GridLayout(2, 1));

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 3));

        JButton enter = new JButton("Enter");
        JButton incrementInfo = new JButton("Increment ID");
        JButton setCurrentTimeDate = new JButton("Current Time/Date");
        JButton findRate = new JButton("Find Yield Rate");

        southPanel.add(findRate);
        southPanel.add(setCurrentTimeDate);
        southPanel.add(incrementInfo);
        southPanel.add(enter);

        JLabel messageLabel = new JLabel("Welcome to the Stringer Application");

        southDivider.add(southPanel);
        southDivider.add(messageLabel);

        // create the GUI objects on the eastPanel
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(5, 2));

        JComboBox cellType = new JComboBox();
        cellType.addItem("Rect");
        cellType.addItem("Cham");
        JLabel cellTypeLabel = new JLabel("Cell Type:");

        JComboBox ecaCode = new JComboBox();
        ecaCode.addItem("A");
        ecaCode.addItem("B");
        JLabel ecaCodeLabel = new JLabel("ECA Code:");

        JTextField ecaSyringeNum = new JTextField();
        JLabel ecaSyringeNumLabel = new JLabel("Eca Syringe #:");

        JComboBox passFail = new JComboBox();
        passFail.addItem("Pass");
        passFail.addItem("Fail");
        JLabel passFailLabel = new JLabel("Pass/Fail:");

        JTextField operator = new JTextField();
        JLabel operatorLabel = new JLabel("Operator:");

        eastPanel.add(operatorLabel);
        eastPanel.add(operator);
        eastPanel.add(cellTypeLabel);
        eastPanel.add(cellType);
        eastPanel.add(ecaCodeLabel);
        eastPanel.add(ecaCode);
        eastPanel.add(ecaSyringeNumLabel);
        eastPanel.add(ecaSyringeNum);
        eastPanel.add(passFailLabel);
        eastPanel.add(passFail);

        // create the GUI objects on the westPanel
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(6, 2));

        JLabel yieldLabel = new JLabel("Current Yield:");
        JLabel yieldValueLabel = new JLabel("Select Date/Times");
        JTextField yieldAfterDate = new JTextField();
        JTextField yieldAfterTime = new JTextField();
        JTextField yieldBeforeDate = new JTextField();
        JTextField yieldBeforeTime = new JTextField();
        JLabel yieldAfterDateLabel = new JLabel("After Date:");
        JLabel yieldAfterTimeLabel = new JLabel("After Time:");
        JLabel yieldBeforeDateLabel = new JLabel("Before Date:");
        JLabel yieldBeforeTimeLabel = new JLabel("Before Time:");
        JLabel setBeforeToCurrentLabel = new JLabel("<html>'Set to Current' for <br> Current Date/Time</html>");
        JButton fillBeforeWithCurrent = new JButton("Set to Current");

        westPanel.add(yieldLabel);
        westPanel.add(yieldValueLabel);
        westPanel.add(yieldAfterDateLabel);
        westPanel.add(yieldAfterDate);
        westPanel.add(yieldAfterTimeLabel);
        westPanel.add(yieldAfterTime);
        westPanel.add(yieldBeforeDateLabel);
        westPanel.add(yieldBeforeDate);
        westPanel.add(yieldBeforeTimeLabel);
        westPanel.add(yieldBeforeTime);
        westPanel.add(setBeforeToCurrentLabel);
        westPanel.add(fillBeforeWithCurrent);

        // create the GUI objects for the centerPanel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 4));

        JTextField date = new JTextField();
        JLabel dateLabel = new JLabel("Date:");
        JTextField time = new JTextField();
        JLabel timeLabel = new JLabel("Time:");
        JTextField stringID = new JTextField();
        JLabel stringIDLabel = new JLabel("String ID:");
        JTextField cellLot = new JTextField();
        JLabel cellLotLabel = new JLabel("Cell Lot #:");
        JTextField cellEff = new JTextField();
        JLabel cellEffLabel = new JLabel("Cell Eff:");
        JTextField comments = new JTextField();
        JLabel commentsLabel = new JLabel("Comments:");

        centerPanel.add(dateLabel);
        centerPanel.add(date);
        centerPanel.add(timeLabel);
        centerPanel.add(time);
        centerPanel.add(stringIDLabel);
        centerPanel.add(stringID);
        centerPanel.add(cellLotLabel);
        centerPanel.add(cellLot);
        centerPanel.add(cellEffLabel);
        centerPanel.add(cellEff);
        centerPanel.add(commentsLabel);
        centerPanel.add(comments);

        // add the panel's to the contentPane
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(northPanel, BorderLayout.NORTH);
        contentPane.add(southDivider, BorderLayout.SOUTH);
        contentPane.add(eastPanel, BorderLayout.EAST);
        contentPane.add(westPanel, BorderLayout.WEST);

//      contentPane.validate();
        setSize(812, 514);

    }

    public static void main(String[] args) {
        Test2 t=new Test2();

//      t.begin();
        t.setVisible(true);
    }
}