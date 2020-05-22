import javax.swing.*;
import java.awt.*;

public class AppFrame2 extends JFrame {

    GridBagLayout gbl;
    GridBagConstraints gbc;
    JPanel leftpanel;
    JPanel rightpanel;

    public AppFrame2() {
        this.setSize(500, 500);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.BLACK);

        // Settning Frame Layout
        gbl = new GridBagLayout();
        //************* New code **************//
        gbl.columnWidths = new int[] {500/3, 500/3*2};
        gbl.rowHeights = new int[] {500};
        gbl.columnWeights = new double[] {1, 1};
        gbl.rowWeights = new double[] {1};
        //************* End code **************//

        gbc = new GridBagConstraints();
        this.setLayout(gbl);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Add Panels
        leftpanel = new JPanel();
        leftpanel.setBackground(Color.green);
        this.addPanels(0, 0, 1, 1, leftpanel); // row, col, height, width component

        rightpanel = new JPanel();
        rightpanel.setBackground(Color.red);
        this.addPanels(0, 1, 1, 2, rightpanel);
    }

    private void addPanels(int row, int col, int height, int width,
                           Component com) {
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.gridheight = height;
        gbc.gridwidth = width;
        gbl.setConstraints(com, gbc);
        this.getContentPane().add(com);
    }

    public static void main(String[] args) {
        new AppFrame2();
    }

}