import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MTGSAMPServerReference extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private static JList list1;
    private static JButton select1;
    public static String selectionMenu = "Main"; //accomplishes nothing

    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            MTGSAMPServerReference gui = new MTGSAMPServerReference();
            gui.createAndShowGUI();
            }
        });
    }

    public void createAndShowGUI() {
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //f.add(new drawOnPanel());
        setSize(1200, 800);
        setLocationRelativeTo(null);
        list1.setSize(250, 250);
        list1.setLocation(0, 0);
        select1.setSize(75, 25);
        select1.setLocation(251, 276);
        setVisible(true);
    }


    public MTGSAMPServerReference() {
        this.getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING));
            Object[]mainMenu = {"Vehicles", "Bikes/Bicycles", "Boats", "Houses", "Businesses", "Objects", "Jobs", "Ranks", "Licenses", "VIP", "FAQ's"};
                Object[]VehiclesValueMenu = {"Lower Class", "Upper Class", "VIP"};
            JPanel controls = new JPanel(new BorderLayout(5,5));
            list1 = new JList<Object>(mainMenu);
            list1.setVisibleRowCount(10);
            select1 = new JButton("Select");
            select1.addActionListener(this);
            controls.add(new JScrollPane(list1));
            controls.add(select1, BorderLayout.PAGE_END);
            controls.setBorder(new EmptyBorder(25,25,0,0));
            add(controls);
            //revalidate(); //uneeded at this point the JFrame is not yet visible, thus nothing to repaint
            //repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Select")) {
            int indexMain = list1.getSelectedIndex();
            System.out.println("Index Selected: " + indexMain);
            String valueMain = (String) list1.getSelectedValue();
            System.out.println("Value Selected: " + valueMain);
            if ("Vehicles".equals(valueMain)) {
                System.out.println("Menu selected: " + selectionMenu);
                getContentPane().removeAll(); //equivalent to this.getContentPane().removeAll();
                revalidate();
                repaint();
            }
        }
    }  
}