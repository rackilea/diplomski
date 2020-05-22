import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelDemo extends javax.swing.JFrame {
  private static final int FRAME_WIDTH = 300;
  private static final int FRAME_HEIGHT = 350;
  private static final int FRAME_X_ORIGIN = 150;
  private static final int FRAME_Y_ORIGIN = 250;

  public static void main(String[] args) {
    // Frame
    JFrame contentPane = new javax.swing.JFrame();
    contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    contentPane.setSize(300, 350);
    contentPane.setResizable(false);
    contentPane.setLayout(new BorderLayout());
    // Payment Panel
    JPanel paymentPanel = new javax.swing.JPanel();
    paymentPanel.setLayout(new BorderLayout());
    // paymentPanel.setPreferredSize(new java.awt.Dimension(270, 90));
    paymentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment Method",
        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));

    // //Components inside Payment Panel
    // //A) Panels: Radio and Details
    JPanel radioPanel = new JPanel();
    radioPanel.setLayout(new GridLayout(3, 1));
    JRadioButton Rbutton1 = new JRadioButton("Credit Card");
    JRadioButton Rbutton2 = new JRadioButton("E-Funds");
    JRadioButton Rbutton3 = new JRadioButton("Check");
    Rbutton3.setSelected(true);
    ButtonGroup Bgroup = new ButtonGroup();
    Bgroup.add(Rbutton1);
    Bgroup.add(Rbutton2);
    Bgroup.add(Rbutton3);
    radioPanel.add(Rbutton1);
    radioPanel.add(Rbutton2);
    radioPanel.add(Rbutton3);

    // I thought of using a panel as a gap, but still didn't work
    /*
     * JPanel gap = new JPanel(); gap.setLayout(new BorderLayout());
     * gap.setPreferredSize(new java.awt.Dimension(10, 90));
     */

    JPanel detailsPanel = new JPanel();
    detailsPanel.setLayout(new GridLayout(2, 2));
    // detailsPanel
    JLabel Accountnum = new JLabel("Account number:");
    JTextField Account = new JTextField();
    Account.setPreferredSize(new java.awt.Dimension(90, 40));
    detailsPanel.add(Accountnum);
    detailsPanel.add(Account);

    // paymentPanel.add(gap, BorderLayout.CENTER);
    paymentPanel.add(radioPanel, BorderLayout.CENTER);
    paymentPanel.add(detailsPanel, BorderLayout.EAST);
    contentPane.add(paymentPanel, BorderLayout.PAGE_START);

    // //Address Information Panel
    JPanel addressPanel = new JPanel();
    addressPanel.setLayout(new BorderLayout());
    addressPanel.setSize(new java.awt.Dimension(270, 80));
    addressPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adress Information",
        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
    contentPane.add(addressPanel, BorderLayout.CENTER);

    // //Components inside the Address Information Panel
    // //A) Labels (Address 1, Address 2,...)
    JPanel InfoLabel = new JPanel();
    InfoLabel.setLayout(new GridLayout(5, 2));
    JLabel address1 = new JLabel("Address 1:");
    JLabel address2 = new JLabel("Address 2:");
    JLabel city = new JLabel("City:");
    JLabel state = new JLabel("State:");
    JLabel zip = new JLabel("Zip Code:");
    JTextField text1 = new JTextField();
    JTextField text2 = new JTextField();
    JTextField text3 = new JTextField();
    JTextField text4 = new JTextField();
    JTextField text5 = new JTextField();

    InfoLabel.add(address1);
    InfoLabel.add(text1);
    InfoLabel.add(address2);
    InfoLabel.add(text2);
    InfoLabel.add(city);
    InfoLabel.add(text3);
    InfoLabel.add(state);
    InfoLabel.add(text4);
    InfoLabel.add(zip);
    InfoLabel.add(text5);

    // //B)Text Fields
    JPanel infotext = new JPanel();
    infotext.setLayout(new GridLayout(5, 1));

    addressPanel.add(InfoLabel, BorderLayout.CENTER);
//    addressPanel.add(infotext);

    JPanel controlPanel = new JPanel();
    controlPanel.setLayout(new FlowLayout());
    JLabel test = new JLabel("test");
    controlPanel.add(test);
    contentPane.add(controlPanel, BorderLayout.PAGE_END);
    contentPane.setVisible(true);
  }
}