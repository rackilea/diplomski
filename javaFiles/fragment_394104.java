public class MyPanel extends JPanel implements ActionListener
...
    button1.addActionListener(this);
    button2.addActionListener(this);
    checkbox1.addActionListener(this);
    timer3.addActionListener(this);

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button1)
        else...
        ... //potentially many elses
    }