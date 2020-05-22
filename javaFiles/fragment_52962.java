import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class LogView extends JPanel {

    private JLabel titleLabel;
    private JTextArea orderViewArea;

    public LogView() {

        setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel();

        titleLabel = new JLabel("Logging Information");
        // titleLabel.setPreferredSize(new Dimension(600,50));

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        String[] tempstuff = { "Active", "ALL", "Stuff" };
        JComboBox stageList = new JComboBox(tempstuff);
        stageList.setSelectedIndex(0);

        JComboBox otherList = new JComboBox(tempstuff);
        otherList.setSelectedIndex(0);

        JLabel dateStart = new JLabel("Date Start:   ");
        JLabel dateEnd = new JLabel("Date End:   ");

        JTextField dateStartField = new JTextField(9);
        JTextField dateEndField = new JTextField(9);

        JPanel datePanel = new JPanel(new FlowLayout());
        datePanel.add(dateStart);
        datePanel.add(dateStartField);
        datePanel.add(dateEnd);
        datePanel.add(dateEndField);

        List<String> s = new ArrayList<String>();
        s.add("test1");
        s.add("test2");
        JList orderJList = new JList();
        orderJList.setListData(s.toArray());
        orderJList
                .setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        orderViewArea = new JTextArea();
        orderViewArea.setEditable(false);
        orderViewArea.setText("Log stuff:\n Pizza\n Rochester\n stuff");

        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(titleLabel, constraints);

        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(stageList, constraints);

        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(datePanel, constraints);


        /*
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(otherList, constraints);
*/
        constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.BOTH;
        mainPanel.add(orderJList, constraints);

        //otherList.setVisible(false);
        JScrollPane scroll = new JScrollPane(orderViewArea);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridheight = 2;
        constraints.ipady = 5;
        constraints.weighty = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.BOTH;
        mainPanel.add(scroll, constraints);

        add(mainPanel);
    }

    public static void main(String args[]){
        JFrame test = new JFrame("TEST");
        test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("test", new LogView());
        tabs.addTab("Test3", new JPanel());
        test.add(tabs);
        test.pack();
        test.setVisible(true);
    }

}