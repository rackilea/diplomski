import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu implements ActionListener
{

    private JPanel panel;
    private JFrame frame;
    private JButton addEvent;
    private JButton delEvent;
    private JLabel label;
    private ImageIcon image;
    private JComboBox viewTypes;
    TextField text = new TextField(20);
    JLabel displayMessage = new JLabel("Select a CATlendar view or you can ADD or DELETE an event!");

    public MainMenu()
    {
        gui();
    }
    ///draws the main menu
    public void gui()
    {

        FlowLayout lay = new FlowLayout();
        panel= new JPanel();
        panel.setBackground(Color.PINK);
        panel.setLayout(lay);

        addEvent = new JButton("ADD EVENT");
        addEvent.setPreferredSize(new Dimension(200, 200));
        addEvent.addActionListener(this);
        ImageIcon catAdd = new ImageIcon(getClass().getResource("im-hungry.png"));
        addEvent.setIcon(catAdd);


        delEvent = new JButton("DELETE EVENT");
        delEvent.setPreferredSize(new Dimension(200, 200));
        delEvent.addActionListener(this);
        ImageIcon catDel = new ImageIcon(getClass().getResource("tres-quatro.png"));
        delEvent.setIcon(catDel);

        image= new ImageIcon(getClass().getResource("uno-dos.png"));
        label=new JLabel("Test");

        String[] viewList = { "Weekly", "Daily", "Monthly" };
        viewTypes = new JComboBox(viewList);
        viewTypes.setSelectedIndex(0);
        viewTypes.addActionListener(this);


        panel.add(viewTypes);
        panel.add(label);
        panel.add(addEvent);
        panel.add(delEvent);
        panel.add(displayMessage);
        panel.setVisible(true);
        frame = new JFrame("CATlendar");
        frame.setVisible(true);
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
    }
    //corresponding to what the user choses to do this method will change the event hashmap or display a calendar view.
    public void actionPerformed(ActionEvent e) {
        String viewSelect = (String)viewTypes.getSelectedItem();

        if(e.getActionCommand().equals("ADD EVENT"))
        {
            panel.add(text);
            displayMessage.setText("Enter the date of the event you would like to delete ");
            String eventDate = text.getText();
        }else if(e.getActionCommand().equals("DELETE EVENT"))
        {
            panel.add(text);    
            displayMessage.setText("Enter the date of the event you would like to add");
            String eventDelDate = text.getText();
        }else if(viewSelect.equals("Weekly"))
        {
            displayMessage.setText("You selected a weekly view");
        }else if(viewSelect.equals("Daily"))
        {
            displayMessage.setText("You selected a daily view");
        }else if(viewSelect.equals("Monthly"))
        {
            displayMessage.setText("You selected a monthly view");
        }else
        {
            displayMessage.setText("pick a view");
        }
        panel.revalidate();
        panel.repaint();
        SwingUtilities.windowForComponent(panel).pack();
    }
    public static void main(String [] args)
    {
        new MainMenu();
    }

}