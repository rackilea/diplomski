import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BorderDemo extends JFrame {
    private JPanel buttonPanel = new JPanel();
    private JPanel propertiesPanel = new JPanel();
    private JButton north = new JButton("North");
    private JButton south = new JButton("South");
    private JButton west = new JButton("West");
    private JButton east = new JButton("East");
    private JButton center = new JButton("Center");
    private BorderLayout border = new BorderLayout();
    private JLabel label = new JLabel("BorderLayout Properties:");
    private JLabel hGapLabel = new JLabel("HGap:");
    private JLabel vGapLabel = new JLabel("VGap:");
    private JTextField hGapField = new JTextField();
    private JTextField vGapField = new JTextField();
    private GridLayout grid = new GridLayout(2, 2);
    private Integer hGapInt;
    private Integer vGapInt;

    public BorderDemo() {
        buttonPanel.setLayout(border);
        buttonPanel.add(north, BorderLayout.NORTH);
        buttonPanel.add(center, BorderLayout.CENTER);
        buttonPanel.add(south, BorderLayout.SOUTH);
        buttonPanel.add(west, BorderLayout.WEST);
        buttonPanel.add(east, BorderLayout.EAST);
        propertiesPanel.setLayout(grid);
        propertiesPanel.add(hGapLabel);
        propertiesPanel.add(hGapField);
        propertiesPanel.add(vGapLabel);
        propertiesPanel.add(vGapField);

        add(buttonPanel, BorderLayout.CENTER);
        add(propertiesPanel, BorderLayout.SOUTH);

        hGapField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hGapInt = Integer.parseInt(hGapField.getText());
                border.setHgap(hGapInt);
                setSize((int) (getWidth() + hGapInt), getHeight());
                validate();
            }
        });

        vGapField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vGapInt = Integer.parseInt(vGapField.getText());
                border.setVgap(vGapInt);
                setSize(getWidth(), (int) (getHeight() + vGapInt));
                validate();
            }
        });
    }

    public static void main(String[] args) {
        BorderDemo borderDemo = new BorderDemo();
        borderDemo.setVisible(true);
        borderDemo.setSize(400, 400);
        borderDemo.setLocationRelativeTo(null);
        borderDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}