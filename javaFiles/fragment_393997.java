import java.awt.*;
 import javax.swing.*; //swing package

 public class Major 
 {


    //defining the constructor
    public Major() 
    {

        JFrame maFrame = new JFrame("The main screen"); //creating main Jframe
        JPanel headPanel = new JPanel(); //creating the header panel
        maFrame.setBackground(Color.LIGHT_GRAY); //setting color of frame
        Container container = maFrame.getContentPane();
        container.setLayout(new GridBagLayout()); //setting layout of main frame
        GridBagConstraints cns = new GridBagConstraints(); //creating constraint
        cns.gridx = 0;
        cns.gridy = 0;
        //cns.gridwidth = 3;
        //cns.gridheight = 4;
        cns.weightx = 0.3;
        cns.weighty = 0.7;
        cns.anchor = GridBagConstraints.FIRST_LINE_START;
        cns.fill = GridBagConstraints.BOTH;
        maFrame.setLocationRelativeTo(null); //centering frame
        headPanel.setBackground(Color.WHITE);
        container.add(headPanel, cns);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        cns.gridx = 1;
        cns.gridy = 0;
        //cns.gridwidth = 7;
        //cns.gridheight = 4;
        cns.weightx = 0.7;
        cns.weighty = 0.7;
        cns.anchor = GridBagConstraints.PAGE_START;
        cns.fill = GridBagConstraints.BOTH;
        container.add(panel, cns);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.DARK_GRAY);
        cns.gridx = 0;
        cns.gridy = 1;
        cns.gridwidth = 2;
        //cns.gridheight = 4;
        cns.weightx = 1.0;
        cns.weighty = 0.3;
        cns.anchor = GridBagConstraints.LAST_LINE_START;
        cns.fill = GridBagConstraints.BOTH;
        container.add(panel1, cns);     

        //JButton button = new JButton("BUTTON");
        //headPanel.add(button);

        maFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //setting the default close operation of JFrame
        maFrame.pack();
        maFrame.setVisible(true); //making the frame visible
    }

    //defining the main method
    public static void main(String[] args) 
    {
        Runnable runnable = new Runnable()
        {
            public void run()
            {
                new Major(); //instantiating the class
            }
        };
        SwingUtilities.invokeLater(runnable);       
    }
}