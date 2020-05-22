public class MyPanel extends JPanel
...
    button1.addActionListener(new ButtonListener());
    button2.addActionListener(new ButtonListener());
    checkbox1.addActionListener(new CheckBoxListener());
    timer3.addActionListener(new TimerListener());

    private class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //do stuff related only to timers
        }
    }