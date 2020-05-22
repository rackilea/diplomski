import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;
import javax.swing.border.*;
class CopyLabel extends JFrame
{

    JPanel panel ;
    JPanel centerPanel;
    int clickCount = 0;
    ByteArrayOutputStream baos;
    ByteArrayInputStream bins;
    public void createAndShowGUI()
    {
        setTitle("Copy JLabel");
        JLabel label1  = new JLabel("JLabel1");
        JLabel label2  = new JLabel("JLabel2");
        panel = new JPanel();
        label1.setForeground(Color.blue);
        label2.setForeground(Color.red);
        panel.add(label1);
        panel.add(label2);
        class MyMouseAdapter extends MouseAdapter
        {
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                clickCount = 1;
                try
                {
                    deepCopy((JLabel)evt.getSource());
                }
                catch (Exception ex){}
            }
        }
        label1.addMouseListener(new MyMouseAdapter());
        label2.addMouseListener(new MyMouseAdapter());
        panel.setBorder(BorderFactory.createTitledBorder("Controllers"));
        getContentPane().add(panel,BorderLayout.SOUTH);
        centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"Drawing Pad",TitledBorder.CENTER,TitledBorder.TOP));
        centerPanel.setLayout(null);
        centerPanel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                if (clickCount == 1)
                {
                    try
                    {
                        pasteLabel(evt.getX(),evt.getY());
                    }
                    catch (Exception ex){}
                }
            }
        });
        getContentPane().add(centerPanel);
        setSize(300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void deepCopy(JLabel label)throws Exception
    {
        baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(label);
        oos.close();
    }
    public void pasteLabel(int x, int y)throws Exception
    {
        if (clickCount == 1)
        {
            bins = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream oins = new ObjectInputStream(bins);
            JLabel obj = (JLabel)oins.readObject();
            centerPanel.add(obj);
            obj.setBounds(x,y,obj.getWidth(),obj.getHeight());
        }
    }
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                CopyLabel cl = new CopyLabel();
                cl.createAndShowGUI();
            }
        });
    }
}