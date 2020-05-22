boolean isRunning = false

button.addActionListener(new YourActionListener());

public class YourActionListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==button)
        {
            if(isRunning)
            {
                isRunning = false;
                button.setText("Click me to start");
                button.revalidate();
            }
            else
            {
                isRunning = true;
                button.setText("Click me to stop");
                button.revalidate();
            }
        }
    }
}