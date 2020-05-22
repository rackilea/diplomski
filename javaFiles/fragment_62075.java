import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest extends JPanel
{
    private JScrollPane myScrollPane;
    private JList myList;
    private ListSelectionListener lSL = new ListSelectionListener()
    {
        @Override
        public void valueChanged(ListSelectionEvent evt)
        {
            if(evt.getValueIsAdjusting())
            {
                System.out.println("Eventhandler called evt.getValueIsAdjusting() true");
                return;
            }
            else
            {
//              String item = (String) evt.getSource();//!!!Exception casting JList to String
                //maybe what you need is getSelectedValue()
                System.out.println("else called myList.getSelectedValue() ="+myList.getSelectedValue());
            }
        }
    };

    private ListTest()
    {
        int noRows = 25;
        Object[] listData = new String[noRows];
        for(int i =0; i < noRows; i++)
            listData[i]= "Oi "+i;
        this.myList = new JList(listData);
        this.myScrollPane = new JScrollPane(myList);
        myList.addListSelectionListener(lSL);
        add(myScrollPane);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {               
                ListTest p = new ListTest();
                JPanel contentPane = new JPanel();
                contentPane.add(p);
                JFrame f = new JFrame();
                f.setContentPane(contentPane);
                f.setSize(800, 600);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }
}