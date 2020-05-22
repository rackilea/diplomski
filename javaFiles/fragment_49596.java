import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JFrame;

import java.awt.Container;

public class TableProps {

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Settings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        /* define Table Properties panel */
        JPanel pTableProperties = new JPanel();
        SpringLayout tpLayout = new SpringLayout();
        pTableProperties.setLayout(tpLayout);
        pTableProperties.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Table Properties"), BorderFactory.createEmptyBorder(5,5,5,5)));
        contentPane.add(pTableProperties);
        layout.putConstraint(SpringLayout.WEST, pTableProperties, 10, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, pTableProperties, 10, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, pTableProperties, -50, SpringLayout.SOUTH, contentPane);
        layout.putConstraint(SpringLayout.EAST, pTableProperties, -10, SpringLayout.EAST, contentPane);

        JButton btnClose = new JButton("Close");
        contentPane.add(btnClose);
        layout.putConstraint(SpringLayout.NORTH, btnClose, 10, SpringLayout.SOUTH, pTableProperties);
        layout.putConstraint(SpringLayout.SOUTH, btnClose, -10, SpringLayout.SOUTH, contentPane);
        layout.putConstraint(SpringLayout.EAST, btnClose, -12, SpringLayout.EAST, contentPane); 

        JButton btnSave = new JButton("Save");
        contentPane.add(btnSave);
        layout.putConstraint(SpringLayout.NORTH, btnSave, 10, SpringLayout.SOUTH, pTableProperties);
        layout.putConstraint(SpringLayout.SOUTH, btnSave, -10, SpringLayout.SOUTH, contentPane);
        layout.putConstraint(SpringLayout.EAST, btnSave, -10, SpringLayout.WEST, btnClose);


        /* define Font Style panel */
        JPanel pFontStyle = new JPanel();
        SpringLayout tfsLayout = new SpringLayout();
        pFontStyle.setLayout(tfsLayout);
        pFontStyle.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Font Style"), BorderFactory.createEmptyBorder(5,5,5,5)));
        pTableProperties.add(pFontStyle);
        tpLayout.putConstraint(SpringLayout.WEST, pFontStyle, 20, SpringLayout.WEST, pTableProperties);
        tpLayout.putConstraint(SpringLayout.NORTH, pFontStyle, 20, SpringLayout.NORTH, pTableProperties);
        tpLayout.putConstraint(SpringLayout.SOUTH, pFontStyle, 160, SpringLayout.NORTH, pTableProperties);
        tpLayout.putConstraint(SpringLayout.EAST, pFontStyle, 250, SpringLayout.WEST, pTableProperties);        

        JLabel labelFontName = new JLabel("Font name:");
        pFontStyle.add(labelFontName);
        tfsLayout.putConstraint(SpringLayout.WEST, labelFontName, 5, SpringLayout.WEST, pFontStyle);
        tfsLayout.putConstraint(SpringLayout.NORTH, labelFontName, 5, SpringLayout.NORTH, pFontStyle);

        JComboBox<String> cb = new JComboBox<String>();
        pFontStyle.add(cb);
        tfsLayout.putConstraint(SpringLayout.WEST, cb, 10, SpringLayout.EAST, labelFontName);
        tfsLayout.putConstraint(SpringLayout.EAST, cb, -10, SpringLayout.EAST, pFontStyle);
        tfsLayout.putConstraint(SpringLayout.NORTH, cb, 3, SpringLayout.NORTH, pFontStyle);

        JCheckBox cbxBold = new JCheckBox("Bold");
        pFontStyle.add(cbxBold);
        tfsLayout.putConstraint(SpringLayout.WEST, cbxBold, -5, SpringLayout.WEST, labelFontName);
        tfsLayout.putConstraint(SpringLayout.NORTH, cbxBold, 2, SpringLayout.SOUTH, cb);

        JCheckBox cbxItalic = new JCheckBox("Italic");
        pFontStyle.add(cbxItalic);
        tfsLayout.putConstraint(SpringLayout.WEST, cbxItalic, 0, SpringLayout.WEST, cbxBold);
        tfsLayout.putConstraint(SpringLayout.NORTH, cbxItalic, 2, SpringLayout.SOUTH, cbxBold);

        JCheckBox cbxUnder = new JCheckBox("Underline");
        pFontStyle.add(cbxUnder);
        tfsLayout.putConstraint(SpringLayout.WEST, cbxUnder, 0, SpringLayout.WEST, cbxItalic);
        tfsLayout.putConstraint(SpringLayout.NORTH, cbxUnder, 2, SpringLayout.SOUTH, cbxItalic);        

        JLabel labelFontSize = new JLabel("Font size:");
        pFontStyle.add(labelFontSize);
        tfsLayout.putConstraint(SpringLayout.WEST, labelFontSize, 20, SpringLayout.EAST, cbxBold);
        tfsLayout.putConstraint(SpringLayout.NORTH, labelFontSize, 10, SpringLayout.SOUTH, cb);

        JComboBox<String> cbFontSize = new JComboBox<String>();
        pFontStyle.add(cbFontSize);
        tfsLayout.putConstraint(SpringLayout.EAST, cbFontSize, 0, SpringLayout.EAST, cb);
        tfsLayout.putConstraint(SpringLayout.WEST, cbFontSize, 10, SpringLayout.EAST, labelFontSize);
        tfsLayout.putConstraint(SpringLayout.NORTH, cbFontSize, 5, SpringLayout.SOUTH, cb);

        /* define Table Data panel */
        JPanel pTableData = new JPanel();
        SpringLayout tdLayout = new SpringLayout();
        pTableData.setLayout(tdLayout);
        pTableData.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Table Data"), BorderFactory.createEmptyBorder(5,5,5,5)));
        pTableProperties.add(pTableData);
        tpLayout.putConstraint(SpringLayout.WEST, pTableData, 20, SpringLayout.EAST, pFontStyle);
        tpLayout.putConstraint(SpringLayout.NORTH, pTableData, 20, SpringLayout.NORTH, pTableProperties);
        tpLayout.putConstraint(SpringLayout.SOUTH, pTableData, 160, SpringLayout.NORTH, pTableProperties);
        tpLayout.putConstraint(SpringLayout.EAST, pTableData, -20, SpringLayout.EAST, pTableProperties);    
        /* ADD OTHER WIDGETS */

        /* define Selection Mode & Options panel */
        JPanel pSMOPanel = new JPanel();
        SpringLayout smoLayout = new SpringLayout();
        pSMOPanel.setLayout(smoLayout);
        pSMOPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Selection Mode & Options"), BorderFactory.createEmptyBorder(5,5,5,5)));
        pTableProperties.add(pSMOPanel);
        tpLayout.putConstraint(SpringLayout.WEST, pSMOPanel, 0, SpringLayout.WEST, pFontStyle);
        tpLayout.putConstraint(SpringLayout.EAST, pSMOPanel, 0, SpringLayout.EAST, pFontStyle);
        tpLayout.putConstraint(SpringLayout.NORTH, pSMOPanel, 20, SpringLayout.SOUTH, pFontStyle);
        tpLayout.putConstraint(SpringLayout.SOUTH, pSMOPanel, -10, SpringLayout.SOUTH, pTableProperties);
        /* ADD OTHER WIDGETS */

        /* define Additional Preferences panel */
        JPanel pAddPrefPanel = new JPanel();
        SpringLayout apLayout = new SpringLayout();
        pAddPrefPanel.setLayout(apLayout);
        pAddPrefPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Additional Preferences"), BorderFactory.createEmptyBorder(5,5,5,5)));
        pTableProperties.add(pAddPrefPanel);
        tpLayout.putConstraint(SpringLayout.WEST, pAddPrefPanel, 0, SpringLayout.WEST, pTableData);
        tpLayout.putConstraint(SpringLayout.EAST, pAddPrefPanel, 0, SpringLayout.EAST, pTableData);
        tpLayout.putConstraint(SpringLayout.NORTH, pAddPrefPanel, 0, SpringLayout.NORTH, pSMOPanel);
        tpLayout.putConstraint(SpringLayout.SOUTH, pAddPrefPanel, -10, SpringLayout.SOUTH, pTableProperties);       
        /* ADD OTHER WIDGETS */


        /* show frame */
        frame.pack();
        frame.setSize(550,475);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}