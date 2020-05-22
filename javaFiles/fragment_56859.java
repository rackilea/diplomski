import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ListMembersView extends JPanel{
    JPanel headerPanel;
    JPanel containerPanel;
    JPanel footerPanel;

    public ListMembersView(){

        initComponents();
        initLayout();
    }

private void initComponents(){

    this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),5));

    headerPanel = new JPanel();
    headerPanel.setBackground(Color.red);
    containerPanel = new JPanel();
    containerPanel.setBackground(Color.yellow);
    footerPanel = new JPanel();
    footerPanel.setBackground(Color.blue);
}    

private void initLayout(){    
    GridBagLayout gridBagLayout = new GridBagLayout();
    this.setLayout(gridBagLayout);

    gridBagLayout.columnWeights = new double[] {1};
    gridBagLayout.rowWeights = new double[] {1, 1, 1};
    GridBagConstraints c = new GridBagConstraints();
    /*Not expand JPanel?*/
    c.fill = GridBagConstraints.BOTH;

    c.gridx=0; c.gridy=0; 
    this.add(headerPanel,c);

    c.gridx=0; c.gridy=1; 
    c.gridwidth = 3;
    this.add(containerPanel,c);

    c.gridx=0; c.gridy=2; 
    this.add(footerPanel,c);

}

public static void main(String[] args) {
    JFrame frame = new JFrame("test");
    frame.setLayout(new BorderLayout());
    frame.add(new ListMembersView());
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}
}