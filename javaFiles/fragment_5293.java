package net.bcr666.javatest;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GuiConversion extends JFrame {
private static final long serialVersionUID = 1L;

private JRadioButton rdoLength = new JRadioButton("Length");
private JRadioButton rdoArea = new JRadioButton("Area");
private JRadioButton rdoVolume = new JRadioButton("Volume");
private JRadioButton rdoWeight = new JRadioButton("Weight");
private JRadioButton rdoLiquidVolume = new JRadioButton("Liquid Volume");

ButtonGroup group = new ButtonGroup();
{
    group.add(rdoLength);
    group.add(rdoArea);
    group.add(rdoVolume);
    group.add(rdoWeight);
    group.add(rdoLiquidVolume);
    rdoLength.setSelected(true);
}

CardLayout layoutCard = new CardLayout();
JPanel pnlCard = new JPanel(layoutCard);

public GuiConversion() {
// Set the title.
setTitle("CONVERTER");

setLayout(new BorderLayout());

// Specify an action for the close button.
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

getContentPane().add(buildSelectionPanel(), BorderLayout.NORTH);
getContentPane().add(pnlCard, BorderLayout.CENTER);

pnlCard.add(buildLengthPanel(), "LENGTH");
pnlCard.add(buildAreaPanel(), "AREA");
pnlCard.add(buildVolumePanel(), "VOLUME");
pnlCard.add(buildWeightPanel(), "WEIGHT");
pnlCard.add(buildLiquidVolumePanel(), "LIQUID VOLUME");

rdoLength.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent arg0) {
        layoutCard.show(pnlCard, "LENGTH");
    }
});
rdoArea.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent arg0) {
        layoutCard.show(pnlCard, "AREA");
    }
});
rdoVolume.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent arg0) {
        layoutCard.show(pnlCard, "VOLUME");
    }
});
rdoWeight.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent arg0) {
        layoutCard.show(pnlCard, "WEIGHT");
    }
});
rdoLiquidVolume.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent arg0) {
        layoutCard.show(pnlCard, "LIQUID VOLUME");
    }
});

pack();
// Display the window.
setVisible(true);
}

private JPanel buildSelectionPanel() {
    JPanel panel = new JPanel(new FlowLayout());

    panel.add(new JLabel("Please select conversion type"));
    panel.add(rdoLength);
    panel.add(rdoArea);
    panel.add(rdoVolume);
    panel.add(rdoWeight);
    panel.add(rdoLiquidVolume);

    return panel;
}

private JPanel buildLengthPanel() {
    JPanel panel = new JPanel(new FlowLayout());

    String[] inputTypes = {"Inches","Feet","Yards"};
    JComboBox<String> cboInputType = new JComboBox<>(inputTypes);
    JTextField txtInputLength = new JTextField(10);
    String[] convertTypes = {"Centimeters","Meters","Feet","Yards","Kilometers"};
    JComboBox<String> cboConvertType = new JComboBox<>(convertTypes);
    JTextField txtConvertLength = new JTextField(10);
    txtConvertLength.setEnabled(false);
    JLabel lblConvertType = new JLabel();
    JButton btnConvertLength = new JButton("Convert");
    btnConvertLength.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                txtConvertLength.setText("");
                lblConvertType.setText("");
                double inputLength = Double.parseDouble(txtInputLength.getText());
                String strInputType = (String) cboInputType.getSelectedItem();
                String strConvertType = (String) cboConvertType.getSelectedItem();
                double convertFactor = 0.0d;
                if ("Inches".equals(strInputType)) {
                    if ("Centimeters".equals(strConvertType)) {
                        convertFactor = 2.54;
                    } else if ("Meters".equals(strConvertType)) {
                        convertFactor = 0.0254;
                    } else if ("Kilometers".equals(strConvertType)) {
                        convertFactor = 0.0000254;
                    } else if ("Inches".equals(strConvertType)) {
                        convertFactor = 1.0;
                    } else if ("Feet".equals(strConvertType)) {
                        convertFactor = 0.0833333;
                    } else if ("Yards".equals(strConvertType)) {
                        convertFactor = 0.0277778;
                    }
                } else if ("Feet".equals(strInputType)) {
                    // some conversion
                } else if ("Yards".equals(strInputType)) {
                    // some conversion
                }

                double convertLength = inputLength * convertFactor;
                txtConvertLength.setText(Double.toString(convertLength));
                lblConvertType.setText(strConvertType);
                GuiConversion.this.pack(); // resize the frame to account for added text
            } catch (Exception ex) {
                // could not convert text to number, should probably warn the user
            }
        }
    });

    panel.add(new JLabel("Convert "));
    panel.add(txtInputLength);
    panel.add(cboInputType);
    panel.add(new JLabel(" to "));
    panel.add(cboConvertType);
    panel.add(btnConvertLength);
    panel.add(new JLabel(" = "));
    panel.add(txtConvertLength);
    panel.add(lblConvertType);

    return panel;
}

private JPanel buildAreaPanel() {
    JPanel panel = new JPanel(new FlowLayout());

    panel.add(new JLabel("Area"));

    return panel;
}

private JPanel buildVolumePanel() {
    JPanel panel = new JPanel(new FlowLayout());

    panel.add(new JLabel("Volume"));

    return panel;
}

private JPanel buildWeightPanel() {
    JPanel panel = new JPanel(new FlowLayout());

    panel.add(new JLabel("Weight"));

    return panel;
}

private JPanel buildLiquidVolumePanel() {
    JPanel panel = new JPanel(new FlowLayout());

    panel.add(new JLabel("Liwuid Volume"));

    return panel;
}

public static void main(String[] args) {
    GuiConversion guiConversion = new GuiConversion();
}
}