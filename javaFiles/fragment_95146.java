import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;


public class SamplePaper5a {

    static final int width = 500;
    static final int hight = 600;

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        JFrame frame = new JFrame("Exam");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(width,hight);
        // don't mix Swing with AWT
        JPanel contain = new JPanel();
        System.out.println(contain.getLayout());
        frame.setContentPane(contain);

        contain.setLayout(new GridLayout(2,2));

        final ArrayList<String>names = new ArrayList<String>();
        final ArrayList<String>values = new ArrayList<String>();

        names.add("dian");
        names.add("maze");
        names.add("carl");
        names.add("John");
        names.add("tan");
        names.add("james");

        values.add("11111");
        values.add("2222");
        values.add("3333");
        values.add("4444");
        values.add("5555");
        values.add("6666");

        final JTextArea txtArea = new JTextArea();
        JButton butt = new JButton(" Enter ");
        contain.add(txtArea);
        contain.add(butt);

        butt.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                for(int i=0;i<values.size();i++)
                {
                    txtArea.setText( txtArea.getText()+" \n "+values.get(i) +"  "+ names.get(i));
                }
            }
        });

        try
        {
            contain.add(new NamePanel2(names,values,1));

        }

        catch(Size2Exception e)
        {
            System.out.print(e);
        }

        frame.setVisible(true);
    }
}

class NamePanel2 extends JPanel
{
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> values = new ArrayList<String>();
    int cols;

    public NamePanel2(ArrayList<String> nam,ArrayList<String> val,int c) throws Size2Exception
    {
        this.names = nam;
        this.values =val;
        this.cols = c;
        // unnecessary
        //JPanel panel = new JPanel();

        // it would be better to define an Object that contains a name/value pair
        if(names.size()!= values.size())
            throw new Size2Exception(" wrong sizes");

        setLayout(new GridLayout(names.size(),cols));

        for(int i = 0; i<names.size();i++)
        {
            add(new JLabel(names.get(i)));
            add(new JTextField(values.get(i)));
        }
        // unnecessary
        //panel.setVisible(true);
    }
}

class Size2Exception extends Exception
{
    public Size2Exception(String str)
    {
        super(str);
    }
}