import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Status extends JFrame implements ActionListener
{
    private TextField tf1 = new TextField();
    private Button btn = new Button("Deploy");
    private JPanel grid;
    private static final int COLUMNS = 8;

    public Status()
    {
        //you forgot to assign it to grid
        grid = new JPanel(new GridLayout(0, COLUMNS)); //0 means any number of rows
        tf1.setColumns(5);// set sixe by number of columns
        //btn.setSize(new Dimension(30,30));
        //there is no need to set size to the btn, but you must add the
        //action listener to it
        btn.addActionListener(this);

        //create a panel to hold controls
        JPanel controls = new JPanel(); //uses FlowLayout by default
        //add controls to it
        controls.add(new JLabel("Number of checkboxes to add "));
        controls.add(tf1);     controls.add(btn);

        //create a panel to hold grid and controls
        JPanel mainPanel = new JPanel(new BorderLayout(5,5));
        //add controls at its top
        mainPanel.add(controls, BorderLayout.NORTH);
        //add grid to its center
        mainPanel.add(grid, BorderLayout.CENTER);
        //add mainPanel to frame
        add(mainPanel);

        //do jframe setting
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == btn)
        {
            //surround with try - catch to protect from wrong input
            int numberOfRows = Integer.parseInt(tf1.getText());
            for (int row = 0; row < numberOfRows; row++)
            {
                for(int col = 0; col< COLUMNS ; col++) {
                    JCheckBox jc = new JCheckBox(""+row+""+col);
                    grid.add(jc);
                }
            }
        }
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new Status());
    }
}