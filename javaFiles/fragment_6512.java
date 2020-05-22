import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Example
{
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try 
                {
                    MyFrame frame = new MyFrame();
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });
    }
}

class MyFrame
{
    private JFrame frame;

    private MyDialog dialog;

    public MyFrame()
    {
        frame = new JFrame();

        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        dialog = new MyDialog(frame);
    }
}

class MyDialog
{
    private JDialog dialog;

    private JPanel mainPanel,
                   panel1,
                   inputPanel1,
                   panel2,
                   inputPanel2;

    private JLabel titleLabel,
                   label1,
                   label2;

    private JCheckBox checkBox1,
                      checkBox2;

    private JTextField textField1,
                       textField2;

    public MyDialog(JFrame frame)
    {
        dialog = new JDialog(frame, true);

        buildPanel();

        dialog.add(mainPanel);

        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    private void buildPanel()
    {
        mainPanel = new JPanel(new GridBagLayout());

        titleLabel = new JLabel("Title");



        checkBox1 = new JCheckBox("checkBox1");

        label1 = new JLabel("label1:");

        textField1 = new JTextField(15);

        inputPanel1 = new JPanel(new FlowLayout(FlowLayout.LEADING));

        inputPanel1.setBorder(BorderFactory.createEmptyBorder(0, 17, 0, 0));  // indent the label and textfield
        inputPanel1.add(label1);
        inputPanel1.add(textField1);

        panel1 = new JPanel(new GridBagLayout());
        Border border1 = BorderFactory.createEtchedBorder();
        panel1.setBorder(border1);
        panel1.add(checkBox1, getConstraints(0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE));
        panel1.add(inputPanel1, getConstraints(0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE));



        checkBox2 = new JCheckBox("checkBox2");

        label2 = new JLabel("label2:");

        textField2 = new JTextField(8);

        inputPanel2 = new JPanel(new FlowLayout(FlowLayout.LEADING)){
            Dimension dim = new Dimension(inputPanel1.getPreferredSize());
            public Dimension getPreferredSize(){
                return new Dimension(dim);
            }
        };
        inputPanel2.setBorder(BorderFactory.createEmptyBorder(0, 17, 0, 0));  // indent the label and textfield
        inputPanel2.add(label2, getConstraints(0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE));
        inputPanel2.add(textField2, getConstraints(1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE));

        panel2 = new JPanel(new GridBagLayout());
        Border border2 = BorderFactory.createEtchedBorder();
        panel2.setBorder(border2);
        panel2.add(checkBox2, getConstraints(0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE));
        panel2.add(inputPanel2, getConstraints(0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE));



        mainPanel.add(titleLabel, getConstraints(0, 0, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE));
        mainPanel.add(panel1, getConstraints(0, 1, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE));
        mainPanel.add(panel2, getConstraints(0, 2, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE));
        // When I fill panel2 horizontally, the checkbox becomes misaligned with the above checkbox:
        //mainPanel.add(panel2, getConstraints(0, 2, 2, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL));


  }

  private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor, int fill)
  {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.insets = new Insets(5, 5, 5, 5);
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.gridx = gridx;
      gbc.gridy = gridy;
      gbc.gridwidth = gridwidth;
      gbc.gridheight = gridheight;
      gbc.anchor = anchor;
      gbc.fill = fill;

      return gbc;
  }

}